public void swap(int x, int y) {
     int tmp = x;
     x = y;
     y = tmp;
     System.out.println(x);  // will print 20 from main
     System.out.println(y);  // will print 10 from main
 }

 // meanwhile, in main
 int x = 10;
 int y = 20;
 swap(x, y);
 System.out.println(x); // still prints 10
 System.out.println(y); // still prints 20