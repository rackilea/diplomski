private static byte[] readBytes(String dir, Context context) throws IOException
{
    FileInputStream fileIn = null;
    DataInputStream in = null;

    byte[] buffer = null;

    fileIn = context.openFileInput(dir);
    in = new DataInputStream(fileIn);

    int length = in.readInt();

    buffer = new byte[length];

    for(int x = 0;x < buffer.length;x++)
        buffer[x] = in.readByte();

    try 
    {
        fileIn.close();
    } catch (Exception e) {}

    try 
    {
        in.close();
    } catch (Exception e) {}

    fileIn = null;
    in = null;

    return buffer;
}

private static void writeBytes(String dir, byte bytes[], Context context) throws IOException
{
    FileOutputStream fileOut = null;
    DataOutputStream out = null;

    fileOut = context.openFileOutput(dir, Context.MODE_PRIVATE);
    out = new DataOutputStream(fileOut);

    int length = bytes.length;

    out.writeInt(length);
    out.write(bytes);
    out.flush();

    try 
    {
        fileOut.close();
    } catch (Exception e) {}

    try 
    {
        out.close();
    } catch (Exception e) {}
}