// Step 1
int divisor = 7;
int dividend = 1;

while (true) {
  // Step 2
  int k = dividend / divisor;  // Floor

  // Step 3
  dividend -= k * divisor;

  // Step 4
  dividend *= 10;
}