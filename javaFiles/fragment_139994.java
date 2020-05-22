private javax.swing.Timer timer;
//...

timer = new Timer(delay, new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        moveDot();
        repaint();
    }
});
timer.start();

//...

if (source.getValueIsAdjusting()) {
    timer.stop();
    timer.setDelay(source.getValue());
    timer.start();
}