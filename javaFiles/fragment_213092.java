private static void drawInterval(int centralLength) {
    // ...
      drawInterval(centralLength - 1);
      drawLine(centralLength, -1);  // Note the additional ", -1"
      drawInterval(centralLength - 1);
    // ...
  }