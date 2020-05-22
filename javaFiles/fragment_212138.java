public void actionPerformed(ActionEvent e) {
    myJLabel.setIcon(frames[currentFrame]);
    currentFame++;
    if (currentFrame >= frames.length) {
        timer.stop();
    }
}