import java.util.Arrays;

// ...

int num1 = 2; // fixed number just for test purposes
int num2 = 2; // fixed number just for test purposes

int[][] ver = new int[num1][num2];
for (int[] row: ver)
    Arrays.fill(row, 0);

System.out.println(ver[0][0]); // prints 0 as expected