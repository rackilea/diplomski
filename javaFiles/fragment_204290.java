public class JavaApplication10 {

/**
 * @param args the command line arguments
 */
public static void main(String[] args) 
{
    try 
    {           
        File imageFile = new File("C:\\Users\\Manesh\\Desktop\\116.jpg"); //This is a cropped image of a chest number.
        BufferedImage img =  ImageIO.read(imageFile);
        //BufferedImageOp grayscaleConv =  new ColorConvertOp(colorFrame.getColorModel().getColorSpace(), grayscaleConv.filter(colorFrame, grayFrame);
        Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);  
        ColorConvertOp op = new ColorConvertOp(cs, null);
        op.filter(img, img); // gray scaling the image
        // Tesseract1 instance = new Tesseract1(); // JNA Direct Mapping
        try 
        {   
            String result = instance.doOCR(img);
            System.out.println("hahahaha");
            System.out.println("The result is: " + result);
        }
        catch (TesseractException e) 
        {
            System.out.println("error:" + e);
        }
    }
    catch (IOException ex) 
    {
        Logger.getLogger(JavaApplication10.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}