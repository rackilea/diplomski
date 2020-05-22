for (int i = 0; i < bands.length; i++) {
   if (bands[i].getScore() > maxValue) {
      maxValue = bands[i].getScore();
      winningBand = i;
   }
}