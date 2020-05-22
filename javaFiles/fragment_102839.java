public void continueToGame()  {
    this.getContentPane().removeAll();
    this.add(new gameScreen());
    revalidate(); // tells layout managers to layout new components
    repaint();  // redraw everything
}