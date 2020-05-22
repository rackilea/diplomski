try
{
    for (;;)
    {
        Object object = in.readObject();
        // ...
    }
}
catch (SocketTimeoutException exc)
{
    // you got the timeout
}
catch (EOFException exc)
{
    // end of stream
}
catch (IOException exc)
{
    // some other I/O error: print it, log it, etc.
    exc.printStackTrace(); // for example
}