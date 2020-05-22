short [] array =new short[255];
 Random rand = new Random();

 for (int i=0; i<array.length; i++) {
     int random_integer = -1;

     //generate integer while it exists in the array
     while(exists(random_integer, array)) {
         random_integer = rand.nextInt(255);
     }

     array[i] = random_integer;
}