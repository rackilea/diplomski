try {
   bufferedReader.read();
} catch (FileNotFoundException e) {
   // FileNotFoundException handled here
} catch (IOException e) {
   // Other IOExceptions handled here
}