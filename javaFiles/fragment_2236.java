public void swap(int x, int y) {
     int tmp = x;
     x = y;
     y = tmp;
 }

 // meanwhile, in main
 int x = 10;
 int y = 20;
 swap(x, y);
 System.out.println(x); // still prints 10
 System.out.println(y); // still prints 20