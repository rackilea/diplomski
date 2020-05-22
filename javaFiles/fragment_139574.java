String[][] classesStrings = new String[2][1];
for (int i = 0; i < classes.length; ++i) {
  for (int j = 0; j < classes[i].length; ++j) {
    classesString[i][j] = new String(classes[i][j], UTF_8);
  }
}