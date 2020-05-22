DataOutputStream dos = null;
try
{
    DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(socket.getOutputStream()));
    // do stuff
}
catch(IOException e)
{
    //stacktrace etc
}
finally
{
    if (dos != null) dos.close();
}