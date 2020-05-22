JFrame f = new JFrame();
JButton b = new JButton();
f.add(b);
f.pack();
f.setVisible(true);
b.addMouseListener(new MouseListener() {
    long start_time, stop_time;
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        start_time = System.currentTimeMillis();
        System.out.println("" + start_time);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        stop_time = System.currentTimeMillis();
        System.out.println("" + stop_time);
        if (stop_time - start_time > 1000) {
            new JFrame().setVisible(true);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
});