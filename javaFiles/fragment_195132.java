Task DoStuff()
{
    return ref.getFile(() => DoWork1())
        .ContinueWith((t1) => DoWork2())
        .ContinueWith(t2 => DoWork3())
        .ContinueWith(t3=> DoStuff());
}