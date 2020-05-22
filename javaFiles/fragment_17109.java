public static boolean isImage(String fileName){
    Pattern pattern = Pattern.compile("([^\\s]+(\\.(?i)(png|jpg|jpeg|gif|bmp))$)");
    Matcher matcher = pattern.matcher(fileName);
    return matcher.matches();
}

public static Dimension getImageDimension(File file){
    ImageInputStream in = null;
    try{
        in = ImageIO.createImageInputStream(file);
        final Iterator<ImageReader> readers = ImageIO.getImageReaders(in);
        if (readers.hasNext()) {
            ImageReader reader = readers.next();
            try {
                reader.setInput(in);
                return new Dimension(reader.getWidth(0), reader.getHeight(0));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                reader.dispose();
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (in != null) try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    return null;
}

public static boolean isImageTooBig(File file){
    boolean isImage = isImage(file.getName());
    if(!isImage) return false;
    Dimension dim = getImageDimension(file);
    int maxW = Integer.parseInt((String) Play.configuration.get("app.upload.image.maxW"));
    int maxH = Integer.parseInt((String) Play.configuration.get("app.upload.image.maxH"));
    if(dim.getWidth() > maxW) return true;
    if(dim.getHeight() > maxH) return true;
    return false;
}