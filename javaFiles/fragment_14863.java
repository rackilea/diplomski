@WebService
public class MyJavaWebService {
    @WebMethod
    public String takeImage(byte[] image, String imageName) {
        //You'll need to write a method to save the image to the server.
        //How you actually implement this method is up to you.  You could
        //just open a FileOutputStream and write the image to a file on your
        //local server.
        this.saveImage(image, imageName);
        //Here is where you come up with your URL for the image.
        return this.computeURLForImage(imageName);
    }
    @WebMethod
    public byte[] getImage(String url) {
        final byte[] loadedImage = this.getImage(url);
        return loadedImage;
    }
}