public static void main(String[] args) {
    Main main = new Main();
    main.init();
}

public void init() {
    events gui = new events();
    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gui.setSize(300, 300);
    gui.setVisible(true);

}