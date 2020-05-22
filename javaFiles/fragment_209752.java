public void createWindow(String title, int height) {
    bg = new Background();
    cha = new DrawCha();
    move = new MoveCha();
    frame = new JFrame();

    JLayeredPane lp = new JLayeredPane();

    h = height;
    w = height;

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.addKeyListener(move);

    lp.add(cha, new Integer(2));
    lp.add(bg, new Integer(1));
    frame.add(lp);
    frame.setSize(w, h);
    frame.setTitle(title);
    frame.setVisible(true);
}