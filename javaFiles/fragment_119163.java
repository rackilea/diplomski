/**
 * Finds the a region in one image that best matches another, smaller, image.
 */
 public static int[] findSubimage(BufferedImage im1, BufferedImage im2){
   int w1 = im1.getWidth(); int h1 = im1.getHeight();
   int w2 = im2.getWidth(); int h2 = im2.getHeight();
   assert(w2 <= w1 && h2 <= h1);
   // will keep track of best position found
   int bestX = 0; int bestY = 0; double lowestDiff = Double.POSITIVE_INFINITY;
   // brute-force search through whole image (slow...)
   for(int x = 0;x < w1-w2;x++){
     for(int y = 0;y < h1-h2;y++){
       double comp = compareImages(im1.getSubimage(x,y,w2,h2),im2);
       if(comp < lowestDiff){
         bestX = x; bestY = y; lowestDiff = comp;
       }
     }
   }
   // output similarity measure from 0 to 1, with 0 being identical
   System.out.println(lowestDiff);
   // return best location
   return new int[]{bestX,bestY};
 }

 /**
 * Determines how different two identically sized regions are.
 */
 public static double compareImages(BufferedImage im1, BufferedImage im2){
   assert(im1.getHeight() == im2.getHeight() && im1.getWidth() == im2.getWidth());
   double variation = 0.0;
   for(int x = 0;x < im1.getWidth();x++){
     for(int y = 0;y < im1.getHeight();y++){
        variation += compareARGB(im1.getRGB(x,y),im2.getRGB(x,y))/Math.sqrt(3);
     }
   }
   return variation/(im1.getWidth()*im1.getHeight());
 }

 /**
 * Calculates the difference between two ARGB colours (BufferedImage.TYPE_INT_ARGB).
 */
 public static double compareARGB(int rgb1, int rgb2){
   double r1 = ((rgb1 >> 16) & 0xFF)/255.0; double r2 = ((rgb2 >> 16) & 0xFF)/255.0;
   double g1 = ((rgb1 >> 8) & 0xFF)/255.0;  double g2 = ((rgb2 >> 8) & 0xFF)/255.0;
   double b1 = (rgb1 & 0xFF)/255.0;         double b2 = (rgb2 & 0xFF)/255.0;
   double a1 = ((rgb1 >> 24) & 0xFF)/255.0; double a2 = ((rgb2 >> 24) & 0xFF)/255.0;
   // if there is transparency, the alpha values will make difference smaller
   return a1*a2*Math.sqrt((r1-r2)*(r1-r2) + (g1-g2)*(g1-g2) + (b1-b2)*(b1-b2));
 }