// to start with
JPanel myUI = createUIPanel();
JFrame frame = new JFrame();
frame.add(myUI);

// .. and later ...

JFrame newFrame = new JFrame();
newFrame.setUndecorated();
newFrame.add(myUI);