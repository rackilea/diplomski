public int getNumberLines(File aFile) {
    int numLines = 0;
    try {

        BufferedReader input =  new BufferedReader(new FileReader(aFile));
            try {
                String line = null;

                while (( line = input.readLine()) != null){ //ReadLine returns the contents of the next line, and returns null at the end of the file.
                    numLines++;
                }
  }
  finally {
    input.close();
  }
}
catch (IOException ex){
  ex.printStackTrace();
}
    return numLines;
}