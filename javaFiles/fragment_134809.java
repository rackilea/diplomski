public int getItem(int x, int y) {
  if ((x < 0 && x > 255) || (y < 0 && y > 255)) {
    return -1; // Or you can throw an exception such as InvalidParameterException
  }
  return myArray[x, y];
}