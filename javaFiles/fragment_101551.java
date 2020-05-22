private void initialize() {
   list[0][0] = 2;
   list[0][1] = 4;
   list[1][0] = 3;
   list[1][1] = 7;

   // simply
   oldList[0] = list[0].clone();
   oldList[1] = list[1].clone();

   // or in a greater 2D arrays
   for (int i = 0; i < list.length; i++) {
      System.arraycopy(list[i], 0, oldList[i], 0, list[0].length);
   }

   going();
}