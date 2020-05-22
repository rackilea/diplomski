// Initial setup
Frame mainFrame = new Frame();
mainFrame.setVisible(true); // you'll also want to set size, location, etc.
mainFrame.createBufferStrategy(2);
BufferStrategy bufferStrategy = mainFrame.getBufferStrategy();

//.... 

// Inside your draw loop (call once for each frame)
Graphics2D g2 = (Graphics2D) bufferStrategy.getDrawGraphics();
g2.drawImage(...) // etc.
g2.dispose();
bufferStrategy.show();