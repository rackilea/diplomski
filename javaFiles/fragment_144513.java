javax.swing.Timer timer = new Timer(1000,new ActionListener() {
     public void actionPerformed(ActionEvent e) {
         colorPanel.repaint();
     }
});
timer.setRepeats(true);

startButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        timer.start();
    }
});

stopButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        timer.stop();
    }
});