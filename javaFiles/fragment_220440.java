// Display table body
// loops running out of bounds (until m.length + 1 instead of m.length-1)
for (int i = 1; i <= m.length + 1; i++) {
   System.out.print(i);
   for (int j = 1; j <= m.length + 1; i++) { // missed to increment j here
      System.out.printf("%4d", i * j); 

   }
   System.out.println();
}