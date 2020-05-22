String password = config.getProperty("username." + usr.toString());
if (password != null && password.equals(pwd.toString())) {
  new DocMenu();
  lgFrame.dispose();
} else {
  JOptionPane.showMessageDialog(lgFrame, "Wrong credentials try again", "Oops", JOptionPane.ERROR_MESSAGE);
}