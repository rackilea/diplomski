JDialog.setDefaultLookAndFeelDecorated(true);
UIManager.put("OptionPane.minimumSize",new Dimension(350,200));
UIManager.put("OptionPane.background", Color.gray);
UIManager.put("Panel.background", Color.lightGray);
UIManager.put("OptionPane.errorDialog.titlePane.foreground", Color.lightGray);
UIManager.put("OptionPane.errorDialog.titlePane.background", Color.black);
UIManager.put("OptionPane.errorDialog.border.background", Color.white);

JOptionPane.showMessageDialog(null, "A basic JOptionPane message dialog", "myBox",0);