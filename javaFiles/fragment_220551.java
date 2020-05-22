// this will close bw no matter what
try (BufferedWriter bw = openWriter()) {
   doStuff();
} catch (IOException e) {
   handleError();
}