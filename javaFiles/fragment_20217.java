public int[] arrMethod3(){
   int[] retVal = new int[y]; // THIS IS THE IMPORANT LINE
   for (int idy = 0; idy < y; idy++){
      double randomInt = randomGenerator.nextDouble();
      retVal[idy]=(int) Math.round(randomInt);
   }
   return retVal;
}