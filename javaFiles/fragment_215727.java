private void loadImage() throws IOException {
    String imgPath = getURL().toExternalForm();
    String ext = imgPath.substring(imgPath.lastIndexOf('.')+1);
    imgPath = imgPath.startsWith(PROTOCOL+"://") ? 
                 imgPath.substring((PROTOCOL+"://").length()) :
                 imgPath.substring((PROTOCOL+":").length());

    try{
        BufferedImage read = ImageIO.read(new File(imgPath));
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(read, ext, os);
        data=os.toByteArray();
    } catch(IOException ioe){
        System.out.println("IO exception: "+ioe);
    }
}