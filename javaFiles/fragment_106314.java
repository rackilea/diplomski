JLabel message = new JLabel("newDocText");
    final JOptionPane pane = new JOptionPane(message, JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_OPTION, null, options);
    JDialog dialog = pane.createDialog(f, "newDoc");
    message.requestFocus();
    dialog.setVisible(true);
    Object selection = pane.getValue();