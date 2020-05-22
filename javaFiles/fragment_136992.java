JFrame theFrame = new JFrame();
// lots of code here to add buttons
Component[] components = theFrame.getComponents();
for (Component component : components) {
    if (component instanceof Button) {
        // do something
    }
}