static class XClassHint {
        public final String resName;
        public final String resClass;

        public XClassHint(final String name, final String cls) {
            this.resName = name;
            this.resClass = cls;
        }

        @Override
        public String toString() {
            return String.format("%s:%s", this.resName, this.resClass);
        }
    }

    private static XClassHint wmClass(X11 x11, X11.Display display, X11.Window window) throws UnsupportedEncodingException {
        final X11.Atom xa_prop_type = X11.XA_STRING;
        final X11.Atom xa_prop_name = X11.XA_WM_CLASS;
        final int MAX_PROPERTY_VALUE_LEN = 4096;

        X11.AtomByReference xa_ret_type_ref = new X11.AtomByReference();
        IntByReference ret_format_ref = new IntByReference();
        NativeLongByReference ret_nitems_ref = new NativeLongByReference();
        NativeLongByReference ret_bytes_after_ref = new NativeLongByReference();
        PointerByReference ret_prop_ref = new PointerByReference();

        NativeLong long_offset = new NativeLong(0);
        NativeLong long_length = new NativeLong(MAX_PROPERTY_VALUE_LEN / 4);

        if (x11.XGetWindowProperty(display, window, xa_prop_name, long_offset, long_length, false,
            xa_prop_type, xa_ret_type_ref, ret_format_ref,
            ret_nitems_ref, ret_bytes_after_ref, ret_prop_ref) != X11.Success) {
            String prop_name = x11.XGetAtomName(display, xa_prop_name);
            throw new RuntimeException("Cannot get " + prop_name + " property.");
        }

        X11.Atom xa_ret_type = xa_ret_type_ref.getValue();
        Pointer ret_prop = ret_prop_ref.getValue();

        if (xa_ret_type == null) {
            //the specified property does not exist for the specified window
            return null;
        }

        if (xa_prop_type == null ||
            !xa_ret_type.toNative().equals(xa_prop_type.toNative())) {
            x11.XFree(ret_prop);
            String prop_name = x11.XGetAtomName(display, xa_prop_name);
            throw new RuntimeException("Invalid type of " + prop_name + " property");
        }

        int ret_format = ret_format_ref.getValue();
        long ret_nitems = ret_nitems_ref.getValue().longValue();

        // null terminate the result to make string handling easier
        int nbytes;
        if (ret_format == 32)
            nbytes = Native.LONG_SIZE;
        else if (ret_format == 16)
            nbytes = Native.LONG_SIZE / 2;
        else if (ret_format == 8)
            nbytes = 1;
        else if (ret_format == 0)
            nbytes = 0;
        else
            throw new RuntimeException("Invalid return format");
        int length = Math.min((int) ret_nitems * nbytes, MAX_PROPERTY_VALUE_LEN);

        byte[] ret = ret_prop.getByteArray(0, length);

        x11.XFree(ret_prop);
        if( ret == null ){
            return null;
        }

        // search for '\0'
        int i;
        for (i = 0; i < ret.length; i++) {
            if (ret[i] == '\0') {
                ret[i] = '.';
            }
        }

        String wcSrc = new String(ret, "UTF8");
        final String[] parts = wcSrc.split("\\.");
        return new XClassHint(parts[0], parts[1]);
    }