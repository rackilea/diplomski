public static String makeBaggage(String country, String flight, int num){

  String x = "";

  for(int i = 0; i < num; i++){
    String[] bgs = new String[num];
    bgs[i] = country + flight + i;
   //  System.out.println(bgs[i]);
  }
  return x;
}