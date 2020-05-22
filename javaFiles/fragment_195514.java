class Move {

public Move() {
  JFrame f=new JFrame();
  f.setSize(500, 500);
  Dea d=new Dea();
  f.add(d);
  f.setVisible(true);
  d.requestFocus();