private static final Random rand = new Random();
 public static int randBetween(int min, int max) {
       return rand.nextInt(max - min + 1) + min;
 }


 int next = rand.nextInt(100) < 10 ? // a 10% chance
            randBetween(10, max) : // random of at least 10
            randBetween(min, max); // otherwise any number.