try
{
    for (;;)
    {
        Object object = in.readObject();
        // ...
    }
}
catch (EOFException exc)
{
    // end of stream
}
// other catch blocks ...