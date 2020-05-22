Toolkit.getDefaultToolkit().getSystemClipboard().addFlavorListener(new FlavorListener() { 
   @Override 
   public void flavorsChanged(FlavorEvent e) {

      System.out.println("ClipBoard UPDATED: " + e.getSource() + " " + e.toString());
   } 
});