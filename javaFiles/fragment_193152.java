JFrame Error = new JFrame ();

String input = null;

while (true){
  try{

    input = JOptionPane.showInputDialog(null,"Enter the 4 digit resistor values:");
    int numInput = Integer.parseInt (input);

    if (numInput >= 1000) {
    break;
    }
    else {
      JOptionPane.showMessageDialog(Error,"Invalid Input.");
    }
  }
  catch (Exception e){
    JOptionPane.showMessageDialog(Error,"Invalid Input.");

  }
}