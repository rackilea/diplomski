public List<Window> find(Pattern title) {
    Display display = x11.XOpenDisplay(null);
    Window root = x11.XDefaultRootWindow(display);
    List<Window> windows = recurse(x11, display, root, title);
    x11.XCloseDisplay(display);
    return windows;
}

private synchronized List<Window> recurse(X11 x11, Display display, Window root, Pattern pattern) {
    List<Window> windows = new ArrayList<>(1);
    X11.WindowByReference windowRef = new X11.WindowByReference();
    X11.WindowByReference parentRef = new X11.WindowByReference();
    PointerByReference childrenRef = new PointerByReference();
    IntByReference childCountRef = new IntByReference();

    x11.XQueryTree(display, root, windowRef, parentRef, childrenRef, childCountRef);
    if (childrenRef.getValue() == null) {
        return Collections.emptyList();
    }

    long[] ids;

    if (Native.LONG_SIZE == Long.BYTES) {
        ids = childrenRef.getValue().getLongArray(0, childCountRef.getValue());
    } else if (Native.LONG_SIZE == Integer.BYTES) {
        int[] intIds = childrenRef.getValue().getIntArray(0, childCountRef.getValue());
        ids = new long[intIds.length];
        for (int i = 0; i < intIds.length; i++) {
            ids[i] = intIds[i];
        }
    } else {
        throw new IllegalStateException("Unexpected size for Native.LONG_SIZE" + Native.LONG_SIZE);
    }

    for (long id : ids) {
        Window child = new Window(id);
        X11.XTextProperty name = new X11.XTextProperty();
        int result = x11.XGetWMName(display, child, name);
        String value = name.value;
        LOGGER.info(String.format("Found window %s result: %d free %s", value, result, name));

        if (value != null && pattern.matcher(value).matches()) {
            windows.add(child);
        }
        windows.addAll(recurse(x11, display, child, pattern));
    }
    return windows;
}