public static void copyStream(InputStream input, OutputStream output, long start, long end)
    throws IOException
{
    for(int i = 0; i<start;i++) input.read(); // dispose of the unwanted bytes
    byte[] buffer = new byte[1024]; // Adjust if you want
    int bytesRead;
    while ((bytesRead = input.read(buffer)) != -1 && bytesRead<=end) // test for EOF or end reached
    {
        output.write(buffer, 0, bytesRead);
    }
}