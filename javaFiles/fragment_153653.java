ImagePanel panel = new ImagePanel();
panel.addMouseListener(new MouseAdapter() {

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Pressed");
    }
});
frame.add(panel);