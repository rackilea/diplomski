catch(SpecialException e)
{
    // do things specific to that exception type;
    // if there are no such things, just do the
    // general catch below
}
catch(Exception e)
{
    // do generic stuff
}