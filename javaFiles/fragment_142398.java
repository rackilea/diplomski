// Update button fonts...
container.revalidate(); // Force the container with the buttons to update
Dimension size = container.getPreferredSize();
Insets insets = frame.getInsets(); // Returns the frame's border requirements
size.width += insets.left + insets.right;    
size.height += insets.top + insets.bottom;
frame.setSize(size);