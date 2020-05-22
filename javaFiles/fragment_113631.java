timer = new Timer(40, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        for (Particle p : particle) {
            p.move();
        }
        repaint();
    }
});