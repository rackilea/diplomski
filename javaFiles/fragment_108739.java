public static void fillGrid() {
    for(int j = 0; j < 6; j++) {
      for (int k = 0; k < 7; k++) {
        gridArray[j][k] = new JPanel();
        gridArray[j][k].add(new Label(emptybox));
        gridPanel.add(gridArray[j][k]);

      }
    }
}