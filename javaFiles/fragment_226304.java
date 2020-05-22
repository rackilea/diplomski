private Picture backgroundDelete;
private Picture backgroundImage;


public ChromaKey(Picture backgroundDelete, Picture backgroundImage)
{  
    this.backgroundDelete = backgroundDelete;
    this.backgroundImage = backgroundImage;
}
public void chromaKey()
{        
     int redValue = 0; int greenValue = 0; int blueValue = 0;      
    Color pixelColor = null;   
    Color pixelColor1 = null;   
    for(int y = 0; y < backgroundImage.getHeight(); y++)             
    {
        for(int x = 0; x < backgroundImage.getWidth(); x++)    
        {
            Pixel targetPixel = new Pixel(backgroundImage,x,y);   
            Pixel targetPixel1 = new Pixel(backgroundDelete,x,y);

            targetPixel = backgroundImage.getPixel(x,y);                
            pixelColor = targetPixel.getColor();

            targetPixel1 = backgroundDelete.getPixel(x,y);
            pixelColor1 = targetPixel1.getColor();

            int targetRed = pixelColor1.getRed();
            int targetBlue = pixelColor1.getGreen();
            int targetGreen = pixelColor1.getBlue();

            int backgroundRed = pixelColor.getRed();
            int backgroundGreen = pixelColor.getGreen();
            int backgroundBlue = pixelColor.getBlue();

            if(targetRed >= 200 && targetBlue >= 200 && targetGreen >= 200) 
            {
                targetPixel1.setRed(backgroundRed);
                targetPixel1.setGreen(backgroundGreen);
                targetPixel1.setBlue(backgroundBlue);

            }
        }
    }
    backgroundImage.show();
    backgroundDelete.show();
}