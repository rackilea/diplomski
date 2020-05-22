public static void WriteFile(File file)
{
    System.out.println("Writing to file");
    //Use a FileWriter to output to file
    FileWriter oFile = null;
    try
    {
        oFile = new FileWriter(file, false); //Set to true if you don't want to overwrite existing contents in file

        // Begin writing to file... line by line
        for (String line : Data)
            oFile.write(line + System.getProperty("line.separator")); //Since notepad doesn't display newline characters (\n) use this
                                                                      //If using another text document viewer then just use + "\n"
        //Flush and close output stream
        oFile.flush();
        oFile.close();
    } catch (IOException e)
    {
        // Handle it!
        e.printStackTrace();
    }
}