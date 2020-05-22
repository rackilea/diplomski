private final Object lock = new Object();

...

void Bar()
{
    synchronized(lock)
    {
        ...
    }
}