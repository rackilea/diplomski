public List<String> read(){
    ArrayList<String> resultList = new ArrayList(); //A Type-Safety (String) ArrayList
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    try {
        String csvLine;
        while ((csvLine = reader.readLine()) != null) {
            String[] row = csvLine.split(","); //row is String Array Object
            for(String eachWord : row) //Iterate each String from the array
            resultList.add(eachWord);  // add String to the Type-Safe ArrayList.
        }
    }catch (IOException ex) {
    throw new RuntimeException("Error in reading CSV file: "+ex);
}
finally {
    try {
        inputStream.close();
    }
    catch (IOException e) {
        throw new RuntimeException("Error while closing input stream: "+e);
    }
}
return resultList;
   }
  }