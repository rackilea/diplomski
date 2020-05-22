frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//frame.setUndecorated(true);
frame.setSize(MW, MH);
//frame.setResizable(false);
frame.setVisible(true);
// ?? Why ?? Besides, it's not doing what you think it is
frame.setLayout(null);

// Add all the stuff to uiPanelMenu ...

frame.getContentPane().add(uiPanelMenu);