int[] arr = new int[100];
public void setRandomIntegerArray(){
  Random randomGenerator = new Random();
  for (int i = 0; i < 100; i++){
      int randomInt = randomGenerator.nextInt(16) + 10;
      arr[i] = randomInt;
  }
}
public int[] getRandomIntegerArray(){
    return arr;
}