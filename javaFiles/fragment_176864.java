InputStream stream = this.getClass().getClassLoader().getResourceAsStream("back/loadingscreen.png");
     BufferedImage bufferedImage=ImageIO.read(stream);
     ImageIcon icon= new ImageIcon(bufferedImage);

     Graphics g = Canvas.getGraphics(); 
        g.drawImage(icon.getImage(), 0, 0, Canvas);