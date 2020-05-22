public class GlobalKeyListenerExample implements NativeKeyListener {
    public void nativeKeyPressed(NativeKeyEvent e) {
            System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
            System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
            System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();

            GlobalKeyListenerExample listener = new GlobalKeyListenerExample()
            GlobalScreen.getInstance().addNativeKeyListener(listener);

        } catch (NativeHookException ex) {
            System.err.println(ex.getMessage());
        }
    }
}