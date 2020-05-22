String filename = "res/raw/testfile.txt";
try
{
    File file = new File(filename);
    if (!file.exists()) {
        if (!file.createNewFile()) {
           throw new IOException("Unable to create file");
        }
    // else { //prompt user to confirm overwrite }

    FileOutputStream fileout = new FileOutputStream(file);
    ObjectOutputStream out = new ObjectOutputStream(fileout);
    out.writeObject(...logic objects...);
} 
catch (Exception ex)
{
    //show the error message
}