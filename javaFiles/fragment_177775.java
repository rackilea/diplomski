public class FTS {

    private ArrayList<File> mFileList; //Resultant list of Files extracted
    private String mBaseDirectory; // The Directory to search
    private long mSubDirectoryCount; // The count of the subdirectories

    //Constructor
    public FTS(String directory) {
        this.mBaseDirectory = directory;
        this.mSubDirectoryCount = 0;
        buildFileListing(this.mBaseDirectory);
    }

    //
    private void buildFileListing(String directory) {
        // Initialise the ArrayList for the result
        if (mFileList == null) {
            mFileList = new ArrayList(){};
        }
        //Get the File (directory to process)
        File dir = new File(directory);
        // Get the List of the Directories contents
        String[] filelist = dir.list();
        // If empty (null) then return
        if (filelist == null) {
            return;
        }
        // Loop through the directory list
        for (String s: filelist) {
            //get the current list item as a file
            File f = new File(dir.getAbsolutePath() + File.separator + s);
             // is it a file or directory?
            if (f.isFile() && !f.isDirectory()) { 
                this.mFileList.add(f);  // If a file then add the file to the extracted list
            } else {
                // If a directory then increment the count of the subdirectories processed
                mSubDirectoryCount++;
                // and then recursively call this method to process the directory
                buildFileListing(f.getAbsolutePath());
            }
        }
    }

    // return the list of extracted files
    public ArrayList<File> getFileList() {
        return this.mFileList;
    }

    // return the number of sub-directories processed
    public long getSubDirectoryCount() {
        return this.mSubDirectoryCount;
    }
}