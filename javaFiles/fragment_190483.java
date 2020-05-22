List<String> content=new ArrayList<String>();
InputStreamReader isr = new InputStreamReader(is);
linereader = new LineNumberReader(isr);
for (int i = 0; i < num; i++) {  // num is  total no of lines in file
    try {
            line = linereader.readLine();
            content.add(line);

         } 
         catch (IOException e) 
         {
        e.printStackTrace();
          }
     }// for ends