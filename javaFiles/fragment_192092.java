public static void main(String[] args) {
  int f = 0;
  int g = 1;

  for(int i = 1; i <= 10; i++)
  {
    System.out.print(f + " ");
    f = f + g;
    g = f - g;
  } 

  System.out.println();
}