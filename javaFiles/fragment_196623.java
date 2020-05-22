for(int x = 0; x < width; x++)
{
    for(int y = 0; y < height; y++) 
    { 
        int index = 0;
        for(int filterX = -filterWidth/2; filterX < filterWidth/2; filterX++)
            for(int filterY = -filterHeight/2; 
                 filterY < filterHeight/2; filterY++)
        {
            int pixelX = x+filterX;
            int pixelY = y+filterY;

            //ensure we're in bounds.
            if(pixelX>-1 && pixelY>-1 && pixelX<w && pixelY<h){
                pixel = image.getPixel(x,y);
                A = (pixel>>24) & 0xFF;
                R = (pixel>>16) & 0xFF;
                G = (pixel>>8) & 0xFF;
                B = pixel & 0xFF;

                RArray[index] = R;
                GArray[index] = G;
                BArray[index] = B;
                ++index;
        }
   }
   //only sort the pieces of the array we've put data into,
   //remember we could be on an edge of the image.
   Arrays.sort(RArray,0,index);
   Arrays.sort(BArray,0,index);
   Arrays.sort(GArray,0,index);
   int medianR = RArray[RArray.length/2];
   int medianB = BArray[BArray.length/2];
   int medianG = GArray[GArray.length/2];

   //last step is to combine medians back into a single integer