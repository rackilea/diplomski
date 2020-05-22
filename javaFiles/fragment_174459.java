Dimension parentSize = pane.getParent().getSize();
// get the initial preferred size - this has to be done before setContentPane()
// the height should, I think, be the border + height of the title bar
// the width is based on the title name, icon, etc. so is not useful
Dimension initSize = internal.getPreferredSize(); 

// then get the insets, which can be used for the horizontal border
Insets insets = internal.getInsets();

Point point = pane.getMousePosition();
int width = parentSize.width - (insets.left+insets.right) - point.x;
int height = parentSize.height - initSize.height -  point.y;
label.setPreferredSize(new Dimension(width, height));