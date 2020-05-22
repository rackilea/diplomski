int reqWidth = reqHeight = 750;

// first set the size
frame.setSize(reqWidth, reqHeight);

// This is not the actual-sized frame. get the actual size
Dimension actualSize = frame.getContentPane().getSize();

int extraW = reqWidth - actualSize.width;
int extraH = reqHeight - actualSize.height;

// Now set the size.
frame.setSize(reqWidth + extraW, reqHeight + extraH);