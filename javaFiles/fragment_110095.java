public class FileReplace {

public static void main(String[] args){
    //The path were your file is
    String path = "C:\\text\\text.txt";
    File file = new File(path);

    //The number you want to delete
    int number = 300;

    //try to create an inputstream from the file
    FileInputStream fis = null;
    try {
        fis = new FileInputStream(file);
    } catch (FileNotFoundException e) {
        //If we are here the file is not found
        e.printStackTrace();
    }

    //make it a buffered reader
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));

    //to store the current line
    String line;

    //array to store the different words
    String[] words;

    //create a second temporally file that will replace the original file
    File file2 = new File("C:\\text\\$$$$$$$$$$.tmp");
    try {
        file.createNewFile();
    } catch (IOException e1) {
        e1.printStackTrace();
    }
    //and create the streams
    FileOutputStream fos = null;
    try {
        fos = new FileOutputStream(file2);
    } catch (FileNotFoundException e1) {
        e1.printStackTrace();
    }
    PrintWriter writer = new PrintWriter(fos);
    try {
        //loop through all lines and 
        while((line = bufferedReader.readLine()) != null){
            //get all the diffent terms
            words = line.split(" ");

            //see if there are 4 terms in there: wall x x x
            //and if the first term equals wall
            //and if the middle number is the number you want to delete
            //if not just copy the line over
            if(words.length == 4 && words[0].equals("wall") && words[2].equals(String.valueOf(number))){
                //now modify the line by removing the middel number
                String newLine = words[0] + " " + words[1] + " " + words[3];

                //write this to the new file
                writer.println(newLine);
            }else{
                //copy the old line
                writer.println(line);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    //close our resources
    writer.close();
    try {
        bufferedReader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    //now we rename the temp file and replace the old file
    //with the new file with the new content
    file.delete();
    file2.renameTo(file);
}