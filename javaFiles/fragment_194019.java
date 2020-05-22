private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           

    WindowEvent  winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);

    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);

    Jframe1  previousFrame = new Jframe1();

    previousFrame.setVisible(true);
}