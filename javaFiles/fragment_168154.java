timer = new Timer(delay, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // whatever you need for the animation
        updatePositions();
        repaint();
    }
});
timer.start();