if (!RegisterHotKey(null, id, MOD_ALT | MOD_NOREPEAT, 0x42)) {
            System.out.println("Error");
            return;
        }

        Pointer<MSG> msgPointer = Pointer.allocate(MSG.class);

        try {
            while (GetMessage(msgPointer, null, 0, 0) != 0) {
                MSG msg = msgPointer.get();
                if (msg.message() == WM_HOTKEY && msg.wParam() == id) {
                    System.out.println("YEAH");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UnregisterHotKey(null, id);
        }