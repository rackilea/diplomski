public String[] readvaluesFromFile(String... PassingManyStrings) {
    File myfile = new File("src/main/resources/file.txt");
    FileInputStream myFileInput = new FileInputStream(errorFile);
    Properties properties = new Properties();
    properties.load(myFileInput);
    myFileInput.close();

    String[] toReturn = new String[ PassingManyStrings.length ];
    int i=0;
    for(String oneProp: PassingManyStrings){
        toReturn[i++] = properties.getProperty(oneProp);
        if( toReturn[i++] == null)
              toReturn[i++] = "There was a problem.";
        else
              toReturn[i++] = "Reference Name: " + oneProp + " : " + toReturn[i++];
    }
    return toReturn;
}