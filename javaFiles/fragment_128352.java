public class CustomMouseListener implements MouseListener{

      public void mouseClicked(MouseEvent e) {
         statusLabel.setText("Mouse Clicked: ("+e.getX()+", "+e.getY() +")");
      }

      public void mousePressed(MouseEvent e) {
      }

      public void mouseReleased(MouseEvent e) {
      }

      public void mouseEntered(MouseEvent e) {
      }

      public void mouseExited(MouseEvent e) {
      }
   }