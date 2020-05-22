private String addImageToHTML(BufferedImage bf) {
    String base64String = "";
    ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
    try {
        ImageIO.write(bf, "png", baos);
        base64String = DatatypeConverter.printBase64Binary(baos.toByteArray());
    }
    catch (IOException e) {
        e.printStackTrace();
    } 
    return "<img style='max-width:100%' src='data:image/png;base64,"+ base64String + "' alt='IMG DESC'/>";
  }