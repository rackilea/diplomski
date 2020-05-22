void reshape(int x, int y, int width, int height) {
   int currentWidth = getWidth();
   int currentHeight = getHeight();
   if (currentWidth!=width || currentHeight!=height) {
      // find out which one has changed
      if (currentWidth!=width && currentHeight!=height) {  
         // both changed, set size to max
         width = height = Math.max(width, height);
      }
      else if (currentWidth==width) {
          // height changed, make width the same
          width = height;
      }
      else // currentHeight==height
          height = width;
   }
   super.reshape(x, y, width, height);
}