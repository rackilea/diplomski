BufferedImage i = null;
BufferedImage img = null;
try 
{
    i = ImageIO.read(new File("icons/br.jpeg"));
    img = new BufferedImage(i.getWidth(),i.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
}
catch (IOException e) 
{
}

//copy the image
img.getGraphics().drawImage(i, 0, 0, null);


for(int x = img.getWidth()-1; x >= 0; x--)
{
    for(int y = img.getHeight()-1; y >= 0; y--)
    {
        Color b = new Color(255, 255, 255);
        img.setRGB(x, y, b.getRGB());
    }
}

//Save New Image
File outputfile = new File("icons/newestSave.jpeg");
ImageIO.write(img, "jpeg", outputfile);