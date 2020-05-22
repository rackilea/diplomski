List<ImageVertex> allImageList = new ArrayList<ImageVertex>();
for (Vertex vertex : allVertex) {
  if (vertex instanceof ImageVertex) {
    allImageList.add((ImageVertex) vertex);
  }
}