File file = new File("Library.txt");
// file.delete();
// file.createNewFile();
for (int i = 1; file.exists(); i++) {
    file = new File(String.format("Library%d.txt", i));
}