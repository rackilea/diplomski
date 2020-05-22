public static void main(String[] args)
  {
     final int NMAX=4;  
      final double XMAX=5;

    System.out.println();

    double x = 1;
    while(x<=XMAX){
      int n = 1;
      while(n<=NMAX){

        System.out.printf("%10.0f",Math.pow(x,n));
        n++;
      }
      System.out.println();
      x++;
    }

  }