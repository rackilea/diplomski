int len = 20;
    String trackBit = "| ";
    int pos = 5;

    for (int x = 0; x < len; x++) {
        if (x == pos) {
          System.out.print("|A");
        }
        else {
          System.out.print(trackBit);
        }
    }