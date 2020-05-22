// create the new JFrame, the one whose content you wish to display
NewJFrame newJFrame = new NewJFrame();

// get its contentPane 
Container newContentPane = newJFrame.getContentPane();

// add this content pane into the displayed JFrame
displayedJFrame.setContentPane(newContentPane);

// revalidate and repaint the JFrame so that its new data is well displayed
displayedJFrame.revalidate();
displayedJFrame.repaint();
// displayedJFrame.pack(); // and you might need to do this if sizes are way off