/**
 * This method will write an array of strings to the given file.
 * If the append flag is set to true, the new data will be added to the end of the file.
 * 
 * Note:
 *  This is not only nor the best way to write to a file.
 * 
 * @param filename - The path to the file you want to write to.
 * @param data - The Strings you want to write to the file.
 * @param append - Should the new data be added to the end of the file?
 * @return If the write operation succeeded.
 */
public static boolean writeStringsToFile(String filename, String[] data, boolean append) {
    boolean resultFlag = true;

    // The file class represents a file on a disk and provides some useful methods
    File file = new File(filename);
    //PrintWriter is used to write various data types to a given writer.
    PrintWriter printWriter = null;

    try {
        //This method will create an empty file, if there's not already one.
        //Will throw an IOException if it experiences an error creating the file.
        file.createNewFile();

        //A PrintWriter needs some kind of writer to output to, we'll use a FileWriter.
        //FileWriter is used for writing to files.
        //Will throw an IOException if the file doesn't exist (It should exist though)
        printWriter = new PrintWriter(new FileWriter(file, append));

        for(int i = 0; i < data.length; i++) {
            //Write the strings to the file, each on a new line.
            printWriter.println(data[i]);
        }

    } catch (IOException e) {
        //Uh oh. There was an error writing to the disk!
        e.printStackTrace();

        //We couldn't write to the disk, make sure we return false to let the caller know.
        resultFlag = false;
    } finally {
        //First check that we managed to create a PrintWriter before we try to close it.
        if (printWriter!=null)
            printWriter.close(); //Release the file from use.
    }

    return resultFlag;
}