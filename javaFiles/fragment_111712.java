String[] options = { "Confirm", "Cancel" };
JPanel panel = new JPanel();
panel.add(new JLabel("Confirm Trade"), BorderLayout.CENTER);
int selected = JOptionPane.showOptionDialog(
               frame, panel,"Confirmation", JOptionPane.YES_NO_OPTION, 
               JOptionPane.PLAIN_MESSAGE, null, options, options[0]);