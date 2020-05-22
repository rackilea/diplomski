File f = new File(filename);
BufferedWriter bw = null;
try
{
   bw = new BufferedWriter(new FileWriter(f));
   bw.write("some data");
} catch (IOException ex)
{
    //do something 
} finally
{
    if (bw != null)
    {
        try
        {
            bw.close();
        } catch (IOException ex)
        {
        }
    }
}