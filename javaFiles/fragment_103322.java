List<Shape> buttons = ...

for each pixel in the picture, top left to bottom right {
   if the pixel is not black {
       if the pixel is not already contained in one of the buttons {
           iterate over every pixel towards the right until you reach a different color
           iterate over every pixel towards the bottom until you reach a different color

           // now you have the bounds of your button
           // create a new Rectangle and add it to your list.
       }
   }
}