public static void writeToLog(String inString)
{
    File f = new File("yourFile.txt");
    boolean existsFlag = f.exists();

    if(!existsFlag)
    {
        try {
            f.createNewFile();
        } catch (IOException e) {
            System.out.println("could not create new log file");
            e.printStackTrace();
        }

    }

    FileWriter fstream;
    try {
        fstream = new FileWriter(f, true);
         BufferedWriter out = new BufferedWriter(fstream);
         out.write(inString+"\n");
         out.newLine();
         out.close();
    } catch (IOException e) {
        System.out.println("could not write to the file");
        e.printStackTrace();
    } 


    return;
}