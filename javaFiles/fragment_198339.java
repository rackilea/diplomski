//the rest of your code...
    while (csvInputStream.hasNext()) {
            String data = csvInputStream.next();

            String[] wordsInLine = data.split(";");

            for (int i = 0; i < wordsInLine.length; i++) {
              System.out.println(wordsInLine[i]);
            }
          }
   //the rest of your code ...