MouseAdapter myListener = new MouseAdapter() {
   public void mousePressed(MouseEvent e){
        player.mousePressed2(e);
   } 
};
someButton.addMouseListener(myListener);
// then when you want to remove it, use the same referenece.
someButton.removeMouseListener(myListener);