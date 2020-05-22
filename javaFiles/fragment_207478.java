JInternalFrame iframe = new JInternalFrame("Title", true, true, true, true);
iframe.setSize(180, 150);
iframe.setVisible(true);
iframe.getContentPane().add(new JScrollPane(new JTextArea("TestText",20,20)));
JDesktopPane desktop = new JDesktopPane();
desktop.add(iframe);