mntmOneToOne.addMouseListener(new MouseAdapter() {
     @Override
     public void mouseClicked(MouseEvent mouseEvent) {
         int count = mouseEvent.getClickCount();
         if (count == 1) {
           Component panel = (Component)mouseEvent.getSource();
           name = panel.getName(); 
         }
     }
});