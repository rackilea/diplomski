public static int getSum(short[] sumArray) {
  int sum = 0;
  for(short i : sumArray) {
    sum += i;
  }
  return sum;
}

...

int sum = getSum(thisArray);

short result = (short) (sum / thisArray.length);