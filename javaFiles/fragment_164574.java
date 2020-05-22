public void addListener(JPanel p, final int x, final int y) {
    p.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            System.out.println(x);
            System.out.println(y);
        }
    });