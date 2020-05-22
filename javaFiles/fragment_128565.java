Random rnd = new Random();
float randomFloat = 0.0f;
do {
   // downcast will cover negative int value range.
   int randomInt = (int) rnd.nextLong(1L << 32); 

   float randomFloat = Float.intBitsToFloat(randomInt);
   // Discard infinities and NaNs.
} while (randomFloat == Float.NEGATIVE_INFINITY ||
         randomFloat == Float.POSITIVE_INFINITY ||
         Float.isNaN(randomFloat));