public void mouseClicked(MouseEvent e) {
     if (SwingUtilities.isRightMouseButton(e)) {
         int index = list.locationToIndex(e.getPoint());
         System.out.println("Item " + index);
      }
 }