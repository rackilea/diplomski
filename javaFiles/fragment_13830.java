String line="";
while ((line = bufferedReader.readLine()) != null) {
    String[] yourLinesOneByOne = line.split(",");
    String[] itemofLine = yourLinesOneByOne[0].split(" ");//within "Space" 
    //itemofLine[0] has "My"
    //itemofLine[1] has "First"
    //itemofLine[2] has "Line"

}