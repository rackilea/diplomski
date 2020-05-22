private static void storeJSON(String rawJSON, String fileName) throws IOException {
    FileWriter fileWriter = null;
    try
    {
        fileWriter = new FileWriter(fileName, true);
        fileWriter.write(rawJSON);
        fileWriter.write("\n");
    }
    catch(IOException ioe)
    {
        System.err.println("IOException: " + ioe.getMessage());
    } finally {
        if(fileWriter!=null) {
            fileWriter.close();
        }
    }
}