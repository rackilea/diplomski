private boolean drawAtAll = false;

private void jButton1ActionPerformed(ActionEvent evt) {
  drawAtAll = true; // ok to draw now
  draw();
}

@Override
public void paint(Graphics g) {
   super.paint(g);
   draw();
}

public void draw() {
  if( !drawAtAll ) return;

  Graphics g = jPanel1.getGraphics();
  ...
}