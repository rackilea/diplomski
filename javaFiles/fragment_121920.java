try {
    Image image = ImageIO.read(new File(name));
    if (image == null) {
        valid = false;
        System.out.println("The file"+name+"could not be opened , it is not an image");
    }
} catch(IOException ex) {
    valid = false;
    System.out.println("The file"+name+"could not be opened , an error occurred.");
}