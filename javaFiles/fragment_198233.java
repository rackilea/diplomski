JFrame toDisplay = new JFrame("Please Wait");
  toDisplay.setAlwaysOnTop(true);
  toDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  toDisplay.setVisible(true);
  toDisplay.setLayout(new FlowLayout());
  toDisplay.setSize(300,200);
  toDisplay.setLocation((int)dimension.getWidth()/3, (int)dimension.getHeight()/3);

  JLabel message = new JLabel("<html>CheapTix is currently running<br /> 
      please do not close this box or open the file <br /> 
      Destinations.txt <br /> 
      until instructed to do so</html>");
  toDisplay.add(message,BorderLayout.CENTER);