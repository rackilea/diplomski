try
{
    while(true) {
        objIn = in.readObject();
        //work with obj
    }
}
catch (EOFException exc)
{
    // end of stream
}
finally
{
    in.close();
}