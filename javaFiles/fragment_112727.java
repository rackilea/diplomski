public void keyPressed(KeyEvent e) {
    switch (e.getKeyCode()) {
        case KeyEvent.VK_2:
            System.out.println("Non Numpad 2");
        case KeyEvent.VK_NUMPAD3:
            System.out.println("NumPad 3");
    }
}