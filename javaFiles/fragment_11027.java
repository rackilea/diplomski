int cols = rows.size() > 0 ? rows.get(0).length : 0;
for (int i = 0; i < cols; i++) {
  for (int j = 0; j < rows.size(); j++) {
    System.out.println(rows.get(j)[i]);
  }
}