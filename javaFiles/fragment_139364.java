boolean prime = true;
int num1 = in .nextInt();
// We know that composite numbers start from 2 and that 1 is neither prime nor composite.
if (num1 < 2) {
   throw new IllegalArgumentException("Number has to greater than 1");
}
for (int i = 2; i < num1; i++) {
    if (num % i == 0) {
        prime = false;
        break;
    }
}
if (prime) {
    System.out.print("Number is a prime");
} else {
    System.out.print("Number is composite");
}