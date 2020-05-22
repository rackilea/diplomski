private class TimerListener implements ActionListener {
  @Override
  public void actionPerformed(ActionEvent e) {
     if (currentCirclesToDraw < ellipseList.size()) {
        currentCirclesToDraw++;
        repaint();
     } else {
        // stop the Timer
        ((Timer)e.getSource()).stop();
     }
  }
}