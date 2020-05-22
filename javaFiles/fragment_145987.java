String line= inputFile.readLine();

   while(line!= null)
   {
       String outputWithHyphen = line;
       if (line.charAt(6) == ' '){
           outputWithHyphen = line.substring(0,6) + '-' + 
           line.substring(7);
       }
       outputFile.println(outputWithHyphen);
       line= inputFile.readLine();
    }