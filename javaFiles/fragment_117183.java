public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_R) {
        System.out.println("Enter or R key typed.");
    } else {
        System.out.println("Something else typed.");
    }
}