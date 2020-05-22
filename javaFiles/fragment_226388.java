JButton button = new JButton("I'm a button!");
button.addMouseListener(new MouseListener() {
  public void mousePressed(MouseEvent me) {
    if (me.isShiftDown()) {
      // Do the function
    }
  }
});