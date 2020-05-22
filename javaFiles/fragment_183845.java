ServletContext context = getServletContext();
InputStream kapil= context.getResourceAsStream("Desktop/images.jpg");
if (kapil != null){
    //the above line generates the exception
    BufferedImage bufferedImage = ImageIO.read(kapil);
} else {
   // Use a logging framework if you have it.
   System.out.println("The input stream is null!");
}