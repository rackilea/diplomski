JOptionPane pane = new JOptionPane("Message", JOptionPane.WARNING_MESSAGE,
        JOptionPane.DEFAULT_OPTION);
JDialog dialog = pane.createDialog("TITLE");
dialog.setLocation(0, 0);
dialog.setVisible(true);

// dialog box shown here

dialog.dispose();
Object selection = pane.getValue();