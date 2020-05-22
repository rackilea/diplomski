public class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage;
    private byte[] data;
    private String name;
    //implements all the operations going to disk...
    public RealImage(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public String getName() {
        //in case we don't have the name of the image
        if (this.name == null) {
            //use a RealImage to retrieve the image name
            //we will create the instance of realImage only if needed
            if (realImage == null) {
                realImage = new RealImage(fileName);
            }
            //getting the image from the real image is highly costly
            //so we will do this only once
            this.name = realImage.getName();
        }
        return this.name;
    }
    @Override
    public byte[] getData() {
        //similar behavior for the data of the image
        if (this.data == null) {
            if (realImage == null) {
                realImage = new RealImage(fileName);
            }
            //highly costly operation
            this.data = realImage.getData();
        }
        return this.data;
    }
}