public MyFrame() {
   setTitle("MyFrame");
   // setSize(300, 200); // let's avoid this
   setDefaultCloseOperation(EXIT_ON_CLOSE);

   MyPanel panel = new MyPanel();

   JButton testButton = new JButton("Test");
   panel.add(testButton);
   add(panel);  // *** here
   pack();  // this tells the layout managers to do their thing
   setLocationRelativeTo(null);  
   setVisible(true);
}