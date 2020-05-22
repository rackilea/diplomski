File file = new File("type your address");

   FileReader reader = new FileReader(file);

   bufferedReader = new BufferedReader(reader);

   String currentLine;

   while((currentLine = bufferedReader.readLine()) != null){

       //in this loop you can access to lines of file by currenLine variable

   }