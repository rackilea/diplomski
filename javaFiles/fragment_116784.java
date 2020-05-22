BufferedImage originalImg = ImageIO.read(new File("kP1jv.png"));
System.out.println("originalImage is: " + originalImg.getWidth() + "x"
                  + originalImg.getHeight());
Dimension d = Toolkit.getDefaultToolkit().getBestCursorSize(
                originalImg.getWidth(), originalImg.getHeight());

final BufferedImage img = originalImg.getSubimage(0, 0, d.width/*-1*/, d.height-1);