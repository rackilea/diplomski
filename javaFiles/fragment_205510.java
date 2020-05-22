public class TraceShape {

    public TraceShape(){
        // Load Plug-in
        MarvinImagePlugin boundary = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.morphological.boundary");

        // Load image
        MarvinImage image = MarvinImageIO.loadImage("./res/person.jpg");

        // Binarize
        MarvinImage binImage = MarvinColorModelConverter.rgbToBinary(image, 245);
        MarvinImageIO.saveImage(binImage, "./res/person_bin.png");

        // Boundary
        boundary.process(binImage.clone(), binImage);
        MarvinImageIO.saveImage(binImage, "./res/person_boundary.png");
    }

    public static void main(String[] args) {
        new TraceShape();
    }
}