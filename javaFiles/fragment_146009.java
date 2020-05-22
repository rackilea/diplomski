public void mousePressed (MouseEvent event){
   Object o = event.getSource();
   JButton b = null;
   String buttonText = "";

   if(o instanceof JButton)
     b = (JButton)o;

   if(b != null)
     buttonText = b.getText();

}