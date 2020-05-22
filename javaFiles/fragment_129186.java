public void paintComponent(Graphics g){ // draw graphics in the panel

  super.paintComponent(g);// to make panel display correctly
  g.drawImage(dojo, 0,0, this);
  //draws out dojo
  g.drawImage(apple, 0,0, this);
  g.drawImage(orange, 0,0, this);
  g.drawImage(pineapple, 0,0, this);
  g.drawImage(banana, 0,0, this);
  g.drawImage(strawberry, 0,0, this);
  //draws out the fruits somewhere
}