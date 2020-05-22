File f = new File(filename);
try(BufferedWriter bw = new BufferedWriter(new FileWriter(f)))
{
   bw.write("some data");
} catch (IOException ex)
{
    //do something 
}