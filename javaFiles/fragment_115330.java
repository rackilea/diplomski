private JPanel newPanel; // create variable of class level
 private JTextArea outPut;
 //Create constructor 
  public MovieCalculatorJFrame()   //constructor 
  {
    setTitle("Profits Calculator");
    newPanel = new JPanel(); //instancia
    outPut = new JTextArea();
    ....
   // end to constructor
   newPanel.add(outPut);
   add(newPanel);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setVisible(true); 
   pack();
  }