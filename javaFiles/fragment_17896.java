public void go() {
    f = new JFrame();
    MyPanel p = new MyPanel();

    f.getContentPane().add(p);
    f.setSize(300, 300);
    f.setVisible(true);

    Timer timer = new Timer(5, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            p.move();
        }
    });
    timer.start();

}