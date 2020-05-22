public GetScreens(String aFileName) throws FileNotFoundException{
    fFile = new File(aFileName);
    filePath = aFileName;
    try
    {
        countLines();
        x = new int[lines];
        y = new int[lines];
        processLineByLine();
    } catch(FileNotFoundException fnfe) {
        System.out.println(fnfe.getMessage());
    }
    catch(IOException ioe) {
        System.out.println(ioe.getMessage());
    }
}