try {
   bufferedReader.read();
} catch (IOException e) {
   // All IOExceptions (and of course subclasses of IOException) handled here
} catch (FileNotFoundException e) {
   // Would never enter this block, because FileNotFoundException is a IOException
}