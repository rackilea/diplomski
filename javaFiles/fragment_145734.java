// Assume you have a private class variable called
private String lineseparator=System.getProperty("line.separator");

// This method is in charge of calling the method that actually carries out the 
// reading and writing. I separate them both because I find it is much cleaner
// to have the try{}catch{} blocks in different methods. Though sometimes for
// logging purposes this is not the best choice
public void addLines() {
    try {
        readAndWrite();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

// This method is in charge of reading one file and output to another. 
public void readAndWrite() throws IOException {
    File test = new File("test.txt");
 FileWriter writer = writer = new FileWriter(new File("log.txt"), true);
     //This FileWriter is in charge of writing to your log file

 String line;
 boolean conditionToWriteNewLine=true;
      //Obviously this needs to be changed to suit your situation
      // I just added it for show

 BufferedReader reader = new BufferedReader( new FileReader (test));
 BufferedWriter out = new BufferedWriter(writer);

     //It is in this while loop that you read a line
     // Analyze whether it needs to have a new line or not
    // and then write it out to log file
 while( ( line = reader.readLine() ) != null ) {
        out.write(line); 
        if(conditionToWriteNewLine){
           out.write(this.lineseparator); 
           out.write(this.lineseparator);
               //You need to write it twice for an EMPTY LINE
        }     
 }
 reader.close();
 out.close();   
 }