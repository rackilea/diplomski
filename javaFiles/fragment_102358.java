BufferedReader bufReader = new BufferedReader(new InputStreamReader(file.getContent().getInputStream()));
 StringBuilder result = new StringBuilder();
 int readInInt = -1;
 String charsSinceLastLineSep = "";

 if (bufReader.ready()) {
     while (-1 != (readInInt = bufReader.read())) {
        char readInChar = (char) readInInt;

        // if new line reset line buffer, otherwise add to buffer
        if (readInChar == '\n' || readInChar == '\r') {
           charsSinceLastLineSep = "";
        } else {
           charsSinceLastLineSep += readInChar;
        }

        result.append(readInChar);
     }
     bufReader.close();

     // remove all characters added since last Carriage Return or NewLine was found indicating
     // that line was not a complete log line
     String resultString = (result.subSequence(0, (result.length() - charsSinceLastLineSep.length())).toString());