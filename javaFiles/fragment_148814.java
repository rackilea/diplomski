public static void flashWindow(final Shell shell, boolean flashTray,
        boolean flashWindow) {
    try {
        if (isActiveWindow(shell)) {
            flashWindow = false;
            flashTray = false;
        }
        User32 lib = (User32) getLibrary("user32", User32.class);
        User32.FLASHWINFO flash = new User32.FLASHWINFO();
        flash.hWnd = new W32API.HANDLE(new W32API.UINT_PTR(shell.handle)
                .toPointer());
        flash.uCount = 2;
        flash.dwTimeout = 1000;
        if (flashTray || flashWindow) {
            flash.dwFlags = (flashTray ? User32.FLASHW_TRAY : 0)
                    | (flashWindow ? User32.FLASHW_CAPTION : 0);
        } else {
            flash.dwFlags = User32.FLASHW_STOP;
        }
        flash.cbSize = flash.size();
        if (lib.FlashWindowEx(flash) && !flashWindow) {
            final FocusListener focusListener = new FocusListener() {
                public void focusGained(FocusEvent arg0) {
                    flashWindow(shell, false, false);
                    shell.removeFocusListener(this);
                }

                public void focusLost(FocusEvent arg0) {
                }
            };
            shell.addFocusListener(focusListener);
        }
    } catch (UnsatisfiedLinkError e) {
    }
}