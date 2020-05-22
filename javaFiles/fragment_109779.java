@Override
public void paintComponent(Graphics g) {
  super.paintComponent(g);  // ****** be sure to add this ******
  nextlevel(h,w); 
  g.drawImage(image,x,y,wp,hp,null);
}