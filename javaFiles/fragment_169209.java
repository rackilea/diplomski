for (int k = 0; k < number.length; k++) {
  int total = 0;
  for (int i = 0; i < number[k].length; i++) {
    total += number[k][i];
  }
  System.out.println(total);
}