public MyConstructor() {
   final int localIntVar = 3;  // this must be final

   myJButton.addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
         // because you use the local variable inside of an anon inner class
         // not because this is a Swing application
         System.out.println("localIntVar is " + localIntVar);
      }
   });
}