public static void main(String[] args) {    
  int x = 2;

  int y = 1; //starts at 1
  int z;

  while (y < 10) {

    z = x * y;

    System.out.println(x + " x " + y + " = " + z); 
    y++; // increment y after the print statement
  }
}