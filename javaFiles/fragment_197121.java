public SpaceInvaders() {
    add(new Board());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(500, 500);
    setVisible(true);
    requestFocusInWindow();
}

public static void main(String[] args) {
        new SpaceInvaders();
}