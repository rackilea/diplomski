screen.setPreferredSize(new Dimension (600,400));
frame.setContentPane(screen);
frame.pack();
// frame will now be the size it needs to display the contents 
// and the frame's own decorations (title bar etc.)
// ..now add a nice tweak.
frame.setMinimumSize(frame.getSize());