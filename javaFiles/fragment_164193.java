public void save() {

PrintWriter pw=null;
    try{
        pw = new PrintWriter(new FileWriter("directory.txt", true)); 

        for (DirectoryEntry x : theDirectory) {
            pw.write(x.getName());
            pw.write(x.getNumber());

        }

    }
    catch(IOException e)
    {
     e.printStackTrace();
    }

finally
{
   pw.close();
}

    }