public class DisplayBitmaps extends UiApplication
{
    public static void main(String[] args)
    {
        DisplayBitmaps theApp = new DisplayBitmaps();       
        theApp.enterEventDispatcher();
    }

    public DisplayBitmaps()
    {     
        pushScreen(new DisplayBitmapsScreen());
    }    
}

final class DisplayBitmapsScreen extends MainScreen
{
    DisplayBitmapsScreen() {  
        try {
            Thread.sleep(2000); // wait for the simulator SDCard to initialize in this example, on a phone this may take longer
            // for a better way see http://www.blackberry.com/knowledgecenterpublic/livelink.exe/fetch/2000/348583/800332/1295814/How_To_-_Programmatically_determine_if_a_microSD_card_has_been_inserted.html?nodeid=1295868&vernum=0 
            FileConnection fc = (FileConnection) Connector.open("file:///SDCard/BlackBerry/pictures/image.png");
            if (fc.exists()) {
                byte[] image = new byte[(int) fc.fileSize()];
                InputStream inStream = fc.openInputStream();
                inStream.read(image);
                inStream.close();
                //EncodedImages are useful for further file manipulation, otherwise you can go straight to Bitmap
                //EncodedImage encodedImage = EncodedImage.createEncodedImage(image, 0, -1); 
                //Bitmap bitmap = encodedImage.getBitmap();
                Bitmap bitmap = Bitmap.createBitmapFromBytes(image, 0, -1, 1);
                BitmapField bitmapField = new BitmapField(bitmap);
                fc.close();
                add(bitmapField);
            }
        } catch (Exception e) { System.out.println("EXCEPTION " + e); }
    }

    public void close()
    {  
        super.close();
    }   
}