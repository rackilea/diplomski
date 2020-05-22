public static BigInteger factorial(int n){
  int index = n;
  BigInteger total = BigInteger.valueOf(1);
  while(index > 0){
     total = total.multiply(BigInteger.valueOf(index));
     index --;
  }

  return total;
}