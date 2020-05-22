public String readLine(int lineNumber, File aFile) {
        String lineText = "";
        try {

            BufferedReader input =  new BufferedReader(new FileReader(aFile));
                try {
                     for(int count = 0; count < lineNumber; count++) {
                        input.readLine();  //ReadLine returns the contents of the next line, and returns null at the end of the file.
                     }
                     lineText = input.readLine();
      }
      finally {
        input.close();
      }
    }
    catch (IOException ex){
      ex.printStackTrace();
    }
        return lineText;
    }