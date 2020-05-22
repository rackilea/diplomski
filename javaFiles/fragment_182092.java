class GUI extends JFrame {
    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        Trawa t = new Trawa();//this is a JPanel as well as a KeyListner
        add(t);
        this.addKeyListener(t);
        setLayout(new GridLayout(1, 5));
        pack();
        setSize(500, 400);
        setLocation(40, 100);
        setVisible(true);

    }
}