try
{
    operationWhichMightThrow();
}
catch (ArrayIndexOutOfBoundsException e)
{
    log.warning("Failed file " + filename, e);
    // Do whatever you need to continue to the next file.
}