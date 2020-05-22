class MyImage
{
    private String resourceName;
    private GImage gImage;

    public MyImage(String resourceName,int x, int y){
        this.resourceName = resourceName;
        this.gImage = new GImage(resourceName,x,y)
    }

    public String getResourceName()
    {
        return resourceName;
    }

    //.
    //.
    //.
}


public static final String RES_IMG_SUNSET = "sunset.jpg";

//.
//.
//.

MyImage image1 = new MyImage("bar.jpg", 0, 0);
MyImage image2 = new MyImage(RES_IMG_SUNSET, 100, 0);
MyImage image3 = new MyImage("bar.jpg", 200, 0);

if(image2.getResourceName().equals(RES_IMG_SUNSET))
{
}