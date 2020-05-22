int count = 0;
int a = 1;
while (a < 20) {
   count++;
   if ((++a % 3) == 0)
      System.out.println("Divisible 3");
   else if ((a++ % 3) > 0)
      System.out.println("Not Divisible 3");
      else break;
   }
System.out.println("count = " + count);