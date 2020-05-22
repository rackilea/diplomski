class YourClass{
 private ActionListener lowerActionListener = new java.awt.event.ActionListener() { 
   void actionPerformed(java.awt.event.ActionEvent evt) { 
    //doSomething 
   }
 };

 //...
 // maybe in the constructor, after object-creation
 lowerCB.addActionListener(lowerActionListener);

 //...
 // in th actionPerfomed() method
 lowerCB.removeActionListener(lowerActionListener);

}