public static String getName() {
    JPasswordField jpf = new JPasswordField(24);
    JLabel jl = new JLabel("Enter Your Name: ");
    Box box = Box.createHorizontalBox();
    box.add(jl);
    box.add(jpf);
    int x = JOptionPane.showConfirmDialog(null, box, "Name Entry", JOptionPane.OK_CANCEL_OPTION);

    if (x == JOptionPane.OK_OPTION) {
      return jpf.getText();
    }
    return null;
  }