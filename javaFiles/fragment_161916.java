public static double[] init(int a, double n) {
   Scanner scan = new Scanner(System.in);
   double[] newArray = new double[a];
   for (int i = 0; i < n; i++) {
    newArray[i] = scan.nextDouble();
      }
      return newArray;
  }