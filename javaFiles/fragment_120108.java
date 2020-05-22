class A{
      public static int getRandom(int min, int max){ 
        int randomNum = RNG.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}