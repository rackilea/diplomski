int num = 4;    
int cols = (int) Math.sqrt(num); //easier to read the code when stored in a variable
int rows = cols;

String fileStr = "";

scnrIn.useDelimiter("zzzzzzzzz");

while(scnrIn.hasNextLine()) {
    fileStr = scnrIn.nextLine();
    char[] charArray = fileStr.toCharArray();

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < charArray.length; j++) {
            char curChar = charArray[j]; //this is the current character we want to write out for the number of columns times

            for (int k = 0; k < cols; k++) {
                writer.write(curChar);
            }
        }
        writer.newLine(); //create a new line after every row
    }
    writer.flush(); //better to only flush output when fully done
}