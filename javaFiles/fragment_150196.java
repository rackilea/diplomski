public static void main(String[] args) {
    for (int num = 2; num < 2000; num++) {
      boolean prime = false;
      if (num % 2 != 0) {
        if (num % 3 != 0) {
          if (((num + 1) % 6) == 0) prime = true;
          if (((num - 1) % 6) == 0) prime = true;
        }
      }
      System.out.println(num + " prime? " + prime);
    }
  }