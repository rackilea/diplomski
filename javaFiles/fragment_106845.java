int n = 9;// input;

int result = 1; // because you are multiplying, initial result must be 1
for (int i = 1; i <= n; i++) {
   if (i % 2 == 0) { // ignore all odd numbers
      result *= i; // multiply result with next even value
   }
}
System.out.println(result); // print the result: 384