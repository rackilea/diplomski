public static void writeOutMethod1(File file, List<Color> colorList) throws FileNotFoundException {
  PrintWriter pw = new PrintWriter(file);
  for (Color color : colorList) {
     pw.printf("%08x ", color.getRGB());
  }
  pw.close();
}