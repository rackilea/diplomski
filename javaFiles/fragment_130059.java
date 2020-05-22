try {
  Files.write(Paths.get(cInputFile), cipherText);
} catch (IOException ex) {
  System.out.println("File Write Error");
  System.exit(-1);
}