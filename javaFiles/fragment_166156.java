public class potpie {

    PrintWriter cr;

    File file1 = new File("trial.txt");
    File file2 = new File("item.txt");

    public void createfile() throws IOException
    {
        cr = new PrintWriter(new FileWriter(file2,true));

        cr.println("User1" + "639755");    

        cr.close();
        file1.delete();
        file2.renameTo(file1);

   }

}