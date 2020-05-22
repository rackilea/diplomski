import org.openimaj.image.MBFImage;
import org.openimaj.image.FImage;
        //You will need several more imports.  Your IDE can handle that.
public class SampleImage {
    public static Main(String args[])
    {
        //Read image in
        MBFImage image = ImageUtilities.readMBF(new File("c:\\file.jpg"));

        //Print out random information
        System.out.println(image.colourSpace);

        //Create Object to preform work.
        AchantaSaliency test = new AchantaSaliency();

        //Get Saliency Map
        test.analyseImage(image);
        FImage newImage = test.getSaliencyMap();

        //Display original image
        DisplayUtilities.displayImage(image);

        //Display new image
        DisplayUtilities.displayImage(newImage);

        //Save new image to file
        ImageUtilities.write(newImage, new File("C:\\test_output.jpg"));

    }    

}