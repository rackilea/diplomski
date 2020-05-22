hwndMain = WIN_INSTANCE.FindWindow(null, "Main Window");

// Note the existing WindowProc so we can restore it later.
prevWndProc = new BaseTSD.LONG_PTR((long) WIN_INSTANCE.GetWindowLong(hwndMain, WinUser.GWL_WNDPROC));

// Register a new WindowProc that we will use to intercept IME messages.
mainListener = new WindowsCallbackListener() {
    @Override
    public int callback(int hWnd, int uMsg, int uParam, int lParam) {
        if (uMsg == WM_IME_STARTCOMPOSITION || (imeComposing && uMsg == WM_KEYDOWN)) {
            imeComposing = true;

            final WinDef.HWND hwndIme = WIN_INSTANCE.FindWindow("SYSIME7_READING_UI", null);

            if (hwndIme != null && !hwndIme.equals(imeWindow)) {
                // We found an IME window that is not the same as the last one. We assume the last one was
                // closed. We need to register our callback with the new window.
                imeWindow = hwndIme;

                final Point imeWindowLocation = getImeWindowLocation();
                WIN_INSTANCE.MoveWindow(hwndIme, imeWindowLocation.x, imeWindowLocation.y, 0, 0, true);

                final BaseTSD.LONG_PTR prevWndProcIme =
                        new BaseTSD.LONG_PTR((long) WIN_INSTANCE.GetWindowLong(hwndIme, WinUser.GWL_WNDPROC));

                imeListener = new WindowsCallbackListener() {
                    @Override
                    public int callback(int hWnd, int uMsg, int uParam, int lParam) {
                        if (uMsg == WM_WINDOWPOSCHANGING) {
                            final WindowPosition pos = new WindowPosition(new Pointer((long)lParam));
                            pos.read();
                            pos.flags |= SWP_NOMOVE;
                            pos.write();
                        }

                        // Call the window's actual WndProc so the events get processed.
                        return WIN_INSTANCE.CallWindowProc(prevWndProcIme, hWnd, uMsg, uParam, lParam);
                    }
                };

                // Set the WndProc function to use our callback listener instead of the window's one.
                WIN_INSTANCE.SetWindowLong(hwndIme, WinUser.GWL_WNDPROC, imeListener);
            }
        }
        else if (uMsg == WM_IME_ENDCOMPOSITION) {
            // We can discard the IME listener since its window is closed. If another one gets opened, we'll
            // create a new listener.
            imeListener = null;
            imeComposing = false;
        }

        // Call the window's previous WindowProc so the event continues to get processed.
        return WIN_INSTANCE.CallWindowProc(prevWndProc, hWnd, uMsg, uParam, lParam);
    }
};

// Set the WindowProc function to use our WindowProc so the event continues to get processed.
WIN_INSTANCE.SetWindowLong(hwndMain, WinUser.GWL_WNDPROC, mainListener);