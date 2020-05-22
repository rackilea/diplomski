private class HandleTextField implements ActionListener {
  @Override
  public void actionPerformed (ActionEvent e) {
    StringBuilder string  = new StringBuilder();

    if (e.getSource () == textFieldArray[0] || 
        e.getSource () == textFieldArray[1]){
      string.append(String.format(
          "1. %s", textFieldArray[0].getText())
        );
      string.append(String.format(
          "2. %s", textFieldArray[1].getText())
        );
    }

    String[] fields = {"Summary of my changes" , string.toString()};

    JOptionPane.showMessageDialog(null, fields, "My suggestion to the course", JOptionPane.WARNING_MESSAGE);
  }
}