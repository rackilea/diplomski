public static void fillGrid() {
    for(int j = 0; j < 6; j++) {
      for (int k = 0; k < 7; k++) {
        gridPanel.add(createOnePanel());

      }
    }
}