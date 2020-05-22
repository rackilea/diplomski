private static void clientWrite(Socket socket)
{
    OutputStream out = null; 
    InputStream in = null;
    try
    {
        in = new FileInputStream("HelloNewPic.jpg");
        out = socket.getOutputStream();
        pipe(in, out);
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
    finally
    {
        close(in);
        close(out);
    }
}

private static void serverRead(Socket socket)
{
    OutputStream out = null; 
    InputStream in = null;
    try
    {
        in = socket.getInputStream();
        out = new FileOutputStream("HelloNewPic_Server.jpg");
        pipe(in, out);
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
    finally
    {
        close(in);
        close(out);
    }
}



/**
 * Close the given Closeable if it is not <code>null</code>,
 * printing an error message if an IOException is caused
 * 
 * @param c The closeable
 */
private static void close(Closeable c)
{
    if (c != null)
    {
        try
        {
            c.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}


/**
 * Fully reads the given input stream and writes the result to the
 * given output stream. The caller is responsible for closing the
 * given streams.
 * 
 * @param in The input stream
 * @param out The output stream
 * @throws IOException If an IO error occurs
 */
private static void pipe(InputStream in, OutputStream out) throws IOException
{
    byte buffer[] = new byte[8192];
    while (true)
    {
        int read = in.read(buffer);
        if (read < 0)
        {
            break;
        }
        out.write(buffer, 0, read);
    }
}