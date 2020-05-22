public class AddText {  
    String[] newLines; // <<add
    File yourFile = new File("YourFileHere.txt"); //add the name of your file in the brackets
    int numLines; 
    String[] lines; 

public AddText() {
...
//doSomethingToStrings();  <<delete
doSomethingElseToStrings(); //  <<add
}


public void writeFile(File aFile) throws FileNotFoundException, IOException {
...
//output.write(lines[count]); <<delete
output.write(newLines[count]); //  <<add
...
}