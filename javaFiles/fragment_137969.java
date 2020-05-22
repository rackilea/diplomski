import java.util.Random;

..stuff..

// create a random instance - you only need one of these
Random r=new Random();

..stuff..

// create a random co-ordinate within the image rectangle
int x=r.nextInt(image.getWidth());
int y=r.nextInt(image.getHeight());