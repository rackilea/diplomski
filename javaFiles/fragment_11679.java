Timer timer = new Timer(5, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        draw = false;
        repaint();
    }
});