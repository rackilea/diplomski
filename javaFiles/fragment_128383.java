public interface MyIShellFolder extends com.sun.jna.platform.win32.COM.IShellFolder {

    // Define your own function invocation.
    // Since your argument signature includes a WString
    // it will be an overloaded version selected when you use the
    // WString argument.
    WinNT.HRESULT ParseDisplayName(WinDef.HWND hwnd, Pointer pbc, WString pszDisplayName, IntByReference pchEaten,
            PointerByReference ppidl, IntByReference pdwAttributes);

    // Do the same extending the inner class
    public static class Converter extends com.sun.jna.platform.win32.COM.IShellFolder.Converter {
        // You are overriding the superclass version of this so you have
        // to define the entire method
        public static MyIShellFolder PointerToIShellFolder(final PointerByReference ptr) {
            final Pointer interfacePointer = ptr.getValue();
            final Pointer vTablePointer = interfacePointer.getPointer(0);
            final Pointer[] vTable = new Pointer[13];
            vTablePointer.read(0, vTable, 0, 13);
            return new MyIShellFolder() {

                @Override
                public WinNT.HRESULT QueryInterface(REFIID byValue, PointerByReference pointerByReference) {
                    Function f = Function.getFunction(vTable[0], Function.ALT_CONVENTION);
                    return new WinNT.HRESULT(
                            f.invokeInt(new Object[] { interfacePointer, byValue, pointerByReference }));
                }

                @Override
                public int AddRef() {
                    Function f = Function.getFunction(vTable[1], Function.ALT_CONVENTION);
                    return f.invokeInt(new Object[] { interfacePointer });
                }

                public int Release() {
                    Function f = Function.getFunction(vTable[2], Function.ALT_CONVENTION);
                    return f.invokeInt(new Object[] { interfacePointer });
                }

                @Override
                public WinNT.HRESULT ParseDisplayName(WinDef.HWND hwnd, Pointer pbc, WString pszDisplayName,
                        IntByReference pchEaten, PointerByReference ppidl, IntByReference pdwAttributes) {
                    Function f = Function.getFunction(vTable[3], Function.ALT_CONVENTION);
                    return new WinNT.HRESULT(f.invokeInt(new Object[] { interfacePointer, hwnd, pbc, pszDisplayName,
                            pchEaten, ppidl, pdwAttributes }));
                }

                @Override
                public WinNT.HRESULT EnumObjects(WinDef.HWND hwnd, int grfFlags, PointerByReference ppenumIDList) {
                    Function f = Function.getFunction(vTable[4], Function.ALT_CONVENTION);
                    return new WinNT.HRESULT(
                            f.invokeInt(new Object[] { interfacePointer, hwnd, grfFlags, ppenumIDList }));
                }

                public WinNT.HRESULT BindToObject(Pointer pidl, Pointer pbc, REFIID riid, PointerByReference ppv) {
                    Function f = Function.getFunction(vTable[5], Function.ALT_CONVENTION);
                    return new WinNT.HRESULT(f.invokeInt(new Object[] { interfacePointer, pidl, pbc, riid, ppv }));
                }

                @Override
                public HRESULT BindToStorage(Pointer pidl, Pointer pbc, REFIID riid, PointerByReference ppv) {
                    Function f = Function.getFunction(vTable[6], Function.ALT_CONVENTION);
                    return new WinNT.HRESULT(f.invokeInt(new Object[] { interfacePointer, pidl, pbc, riid, ppv }));
                }

                @Override
                public HRESULT CompareIDs(WinDef.LPARAM lParam, Pointer pidl1, Pointer pidl2) {
                    Function f = Function.getFunction(vTable[7], Function.ALT_CONVENTION);
                    return new WinNT.HRESULT(f.invokeInt(new Object[] { interfacePointer, lParam, pidl1, pidl2 }));
                }

                @Override
                public HRESULT CreateViewObject(WinDef.HWND hwndOwner, REFIID riid, PointerByReference ppv) {
                    Function f = Function.getFunction(vTable[8], Function.ALT_CONVENTION);
                    return new WinNT.HRESULT(f.invokeInt(new Object[] { interfacePointer, hwndOwner, riid, ppv }));
                }

                @Override
                public HRESULT GetAttributesOf(int cidl, Pointer apidl, IntByReference rgfInOut) {
                    Function f = Function.getFunction(vTable[9], Function.ALT_CONVENTION);
                    return new WinNT.HRESULT(f.invokeInt(new Object[] { interfacePointer, cidl, apidl, rgfInOut }));
                }

                @Override
                public HRESULT GetUIObjectOf(WinDef.HWND hwndOwner, int cidl, Pointer apidl, REFIID riid,
                        IntByReference rgfReserved, PointerByReference ppv) {
                    Function f = Function.getFunction(vTable[10], Function.ALT_CONVENTION);
                    return new WinNT.HRESULT(f.invokeInt(
                            new Object[] { interfacePointer, hwndOwner, cidl, apidl, riid, rgfReserved, ppv }));
                }

                public WinNT.HRESULT GetDisplayNameOf(Pointer pidl, int flags, STRRET pName) {
                    Function f = Function.getFunction(vTable[11], Function.ALT_CONVENTION);
                    return new WinNT.HRESULT(f.invokeInt(new Object[] { interfacePointer, pidl, flags, pName }));
                }

                @Override
                public HRESULT SetNameOf(WinDef.HWND hwnd, Pointer pidl, String pszName, int uFlags,
                        PointerByReference ppidlOut) {
                    Function f = Function.getFunction(vTable[12], Function.ALT_CONVENTION);
                    return new WinNT.HRESULT(
                            f.invokeInt(new Object[] { interfacePointer, hwnd, pidl, pszName, uFlags, ppidlOut }));
                }

                // OLD VERSION THAT YOU WANT TO IGNORE BUT MUST DECLARE
                @Override
                public HRESULT ParseDisplayName(HWND hwnd, Pointer pbc, String pszDisplayName, IntByReference pchEaten,
                        PointerByReference ppidl, IntByReference pdwAttributes) {
                    return null;
                }
            };
        }
    }
}