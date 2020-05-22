public static String selectRandom(String[] names)    
{    
      Random r = new Random();
      int ranNum= r.nextInt(names.length);
      return names[ranNum];

}