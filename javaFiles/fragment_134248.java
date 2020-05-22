// Loop over lines in the file and add them to an ArrayList
String line="";
try{
    while ((line=reader.readLine())!=null) {
        elements.add(line);
    }
}catch (IOException ioe){
    ioe.printStackTrace();
}