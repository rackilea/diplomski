public class LockingKeyDemo {
    static Toolkit kit = Toolkit.getDefaultToolkit();

    public static void main(String[] args) {
        System.out.println("caps lock2 = "
                + kit.getLockingKeyState(KeyEvent.VK_CAPS_LOCK));
}
}