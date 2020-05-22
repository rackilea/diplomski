int decimal = 0;
int power = 0;
int bin = Integer.parseInt("11");

while (bin != 0) {
  int temp = bin%10;
  if(temp > 1) {
  throw new NumberFormatException("Invalid input"); //throw exception if input contains number greater than 0
  } else {
      bin = bin / 10;
      decimal += temp * Math.pow(2, power);
      power++;
  }
}