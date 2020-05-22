private GObject triangle; // this is uninitialized

 public void setUpGame(){

   GPolygon triangle = new GPolygon (WIDTH/2,HEIGHT/2);  // this is hiding your member variable

   // THIS IS LOCAL COPY, NOT MEMBER VARIABLE
   add(triangle);