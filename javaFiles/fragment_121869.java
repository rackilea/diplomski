Scanner regionData = null;

try {
   regionData = newScanner(new File("RU.txt"));
} catch (FileNotFoundException e) {
   // handle what happens if exception is thrown
}