else {
  int size = poly.size();//store the size of ArrayList poly in a variable so that the for loop is definite.
  for (int i = 0; i < size; i++) {
    Term one = poly.get(i);
    if (one.getExp() < a.getExp()) {//check this condition..I guess it is always true for each iteration.
      poly.add(i, a);
      i++;//after adding an element at index i increment it by 1
      size = size + 1;
     }
  }