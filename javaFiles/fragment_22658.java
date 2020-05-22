private void addMouseListenerRecrusively(Container container){

   for (Component component:container.getComponents()){
     if (component instanceof Container)
        addMouseListenerRecrusively(component); 
   }

   container.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            System.out.println("mouse clicked");
        }
    });

}