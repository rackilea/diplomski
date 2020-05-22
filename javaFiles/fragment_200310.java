URLConnection conn;

BufferedInputStream bistream = null;
BufferedOutputStream bostream = null;

boolean failed = false;

try
{
    conn = new URL("http://../image.png").openConnection();

    bistream = new BufferedInputStream(conn.getInputStream(), 512);

    byte[] b = new byte[512];

    int len = -1;

    bostream = 
        new BufferedOutputStream(
            new FileOutputStream(new File("/../image-downloaded.png")));

    while((len = bistream.read(b)) != -1)
    {
        bostream.write(b, 0, len);
    }
}
catch(Exception e) // poor practice, catch each exception separately.
{                   /* MalformedURLException -> IOException -> Exception */
    e.printStackTrace();

    failed = true;
}
finally
{
    if(bostream != null)
    {
        try
        {
            bostream.flush();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                bostream.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    if(bistream != null)
    {
        try
        {
            bistream.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}

if(failed == false)
{
    //code
}
else
{
    // code
}