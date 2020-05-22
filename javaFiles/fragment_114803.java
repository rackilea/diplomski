private void saveToFile()
{
    try{
        File filename = new File("userinfo.txt");
        if (!filename.exists()) {
            filename.createNewFile();
        }
        FileWriter fw = new FileWriter(filename, false); //false so you don't append and overwrite
        BufferedWriter bw = new BufferedWriter(fw);
        //now loop your arraylist of users to resave them to your file
        for(User currUser : users)
        {
            bw.write(currUser.toString());
            bw.newLine();
        }
        bw.close();

    }catch (Exception e)
    {
        e.printStackTrace();
    }
}