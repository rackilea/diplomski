public int getIndexForNumber(int number, int maxIndex) {
  int x = (number - 1) % maxIndex; 

  if (x < 0)
    x += maxIndex;

  retrun x; 
}