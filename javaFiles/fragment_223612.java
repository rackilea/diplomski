// Transparent 16 x 16 pixel cursor image.
BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

// Create a new blank cursor.
Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
    cursorImg, new Point(0, 0), "blank cursor");

// Set the blank cursor to the JFrame.
mainJFrame.getContentPane().setCursor(blankCursor);