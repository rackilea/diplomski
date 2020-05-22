FileOutputStream fos = null;
try
{
    fos = new FileOutputStream("foo.txt");
    PrintWriter out = new PrintWriter(
                          new BufferedWriter(
                              new OutputStreamWriter(fos, "UTF-8")));
    // do what you want to do
    out.flush();
    out.close();
}
finally
{
    // quietly close the FileOutputStream (see Jakarta Commons IOUtils)
}