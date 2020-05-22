public void actionPerformed(ActionEvent e ) {
   try {
    int a = Integer.parseInt( t1.getText() );
   }
   catch(NumberFormatException e ) {
     System.out.println( e.getMessage() );
   }
 }