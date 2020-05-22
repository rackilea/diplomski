class A implements AutoCloseable
{
    @Override
    public void close()
    {
        //log messages
        destroy();
    }
}

class X
{
    // suppose creating object of A within some method
    // enclose in try
    try ( A obj = new A ())
    {
        //use obj
    }
    // at the end of scope, the close() method of A will be called.
}