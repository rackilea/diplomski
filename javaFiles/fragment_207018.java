public void mouseClicked(MouseEvent e) {
   if ((e.getButton() == 1) && oval.contains(e.getX(), e.getY()) ) {
      repaint();
    // JOptionPane.showMessageDialog(null,e.getX()+ "\n" + e.getY());
   }
 }