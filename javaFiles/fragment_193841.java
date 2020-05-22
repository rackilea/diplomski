//At the beginning of your program
UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
//Another option
UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//And another
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

//Or during your program - 
UIManager.setLookAndFeel(lnfName);
SwingUtilities.updateComponentTreeUI(frame);
frame.pack();