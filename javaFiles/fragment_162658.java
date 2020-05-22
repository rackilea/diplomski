public static void printtda() {

  int[][] temps = { {27,28,26,29,30}, {26,25,25,37,40} };

  for (int i=0; i<temps.length; i++) {
    int sum = 0;
    for (int g=0; g< temps[i].length; g++) {
        sum+=temps[i][g];
        System.out.print(temps[i][g] +"  ");
    }
    System.out.println(sum/temps[i].length);
    System.out.println();
  }   
}