public final SelectionKey register(Selector sel, int ops,
                                   Object att)
    throws ClosedChannelException
{
    if (!isOpen())
        throw new ClosedChannelException();
    if ((ops & ~validOps()) != 0)
        throw new IllegalArgumentException();
    synchronized (regLock) {
        if (blocking)
            throw new IllegalBlockingModeException();
...