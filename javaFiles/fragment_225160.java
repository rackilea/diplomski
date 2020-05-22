BufferedImage[] img = new BufferedImage[s.length]; 

for(String st : s)
{
    try
    {
        File fa = new File(st);
        img[i++] = ImageIO.read(fa);
        System.out.println(" inside try block the value of every string = " + st);
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
}