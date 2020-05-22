public void draw() {

         Test test = new Test (20);
         Apples apples = new Apples (50);

        strokeWeight(7);
        point (70,50);

        println( apples.accesTest(test ) );
    }