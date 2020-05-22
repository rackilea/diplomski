for( /*each pixel in the raster, which is represented as int[4]*/ )
{  
   double k = pixel[3] / 255.0;

   double r = (255.0 - pixel[0])*k;
   double g = (255.0 - pixel[1])*k;
   double b = (255.0 - pixel[2])*k;
}