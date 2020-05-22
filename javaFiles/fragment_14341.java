private short hotKeyFlag = 0x00;
private static final short MASK_A = 1 << 0;
private static final short MASK_W = 1 << 1;

...
@Override
public void nativeKeyPressed(NativeKeyEvent e) {
    if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
        GlobalScreen.unregisterNativeHook();
    }
    else if (e.getKeyCode() == NativeKeyEvent.VK_A) {
        hotKeyFlag &= MASK_A;

        // Check the mask and do work.
        if (hotKeyFlag == MASK_A & MASK_W) {
            // Fire Shortcut.
        }
    }
    else if (e.getKeyCode() == NativeKeyEvent.VK_W) {
        hotKeyFlag &= MASK_W;

        // Check the mask and do work.
        if (hotKeyFlag == MASK_A & MASK_W) {
            // Fire Shortcut.
        }
    }
}

@Override
public void nativeKeyReleased(NativeKeyEvent e) {
    if (e.getKeyCode() == NativeKeyEvent.VK_A) {
        hotKeyFlag ^= MASK_A;
    }
    else if (e.getKeyCode() == NativeKeyEvent.VK_W) {
        hotKeyFlag ^= MASK_W;
    }
}