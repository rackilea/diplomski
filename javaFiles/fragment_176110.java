private void saveImage(){
    BufferedImage imagebuf=null;
    try {
        imagebuf = new Robot().createScreenCapture(panel.bounds());
    } catch (AWTException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }  
     Graphics2D graphics2D = imagebuf.createGraphics();
     panel.paint(graphics2D);
     try {
        ImageIO.write(imagebuf,"jpeg", new File("save1.jpeg"));
    } catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println("error");
    }
}