ArrayList<ArrayList<String>> allFilesContents = new ArrayList<ArrayList<String>>();
    for ( File file : fileArray){
       BufferedReader br = new BufferedReader(new FileReader(file));
       ArrayList<String> fileContents = new ArrayList<String>();
       String lineRead = null;
       while((lineRead=br.readLine())!=null){
         fileContents.add(lineRead);
       }
       allFilesContents.add(fileContents);
    }