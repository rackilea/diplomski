public static Picture modifyPicture (Picture p, int value)
 {
  // get width and height of the picture
  int width = p.getWidth();
  int height = p.getHeight();
  System.out.println ("Picture has width of " + width + 
                      " and height of " + height);    
  Picture p2 = new Picture (width, height*value);

  for  (int x = 0 ; x < width ;  ++x )
  {
    for (int y = 0 ; y < height ; ++y )
    {
     Pixel pixel1 = p.getPixel (x,y);
     Color c1 = pixel1.getColor();

     for (int j=1; j < value; j++) {
          Pixel pixel = p2.getPixel (x, y + j * height);
          pixel.setColor( c1 );
     }
   }
 }
 return p2; 
}  // end of method