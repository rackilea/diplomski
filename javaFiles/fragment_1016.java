for (int i = 0; i < 2000; i ++) {
  System.out.print(arr[i]); // note it's not println
  if (i % 7 == 6) { // this will be true after every 7th element
    System.out.println();
  }
}