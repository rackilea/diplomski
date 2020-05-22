public class RealImage implements Image {
    //implements all the operations going to disk...
    private String fileName;
    public RealImage(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public String getName() {
        String name = "";
        //fancy operations to seek for the file in disk (in case it has been deleted)
        //read the data from file in disk
        //get the name
        name = ...;
        return name;
    }
    @Override
    public byte[] getData() {
        byte[] data;
        //again, fancy operations to seek for the file in disk (in case it has been deleted)
        //read the data from file in disk
        //get the image data for displaying purposes
        data = ...;
        return data;
    }
}