private void DesiredButtonActionPerformed(java.awt.event.ActionEvent evt){

 // Add your mentioned code here before coding this.
 try{
 Image image = ImageIO.read(f);
 ImageIcon icon = new ImageIcon(image);
 // JLabel toBeSet = new JLabel(); 
 // considering that you have a JLabel having name as what I've used here
 toBeSet.setIcon(icon);
 }
 catch(IOException ioe){
 System.out.println("Exception occured while setting Image on the Label!");
 }

}