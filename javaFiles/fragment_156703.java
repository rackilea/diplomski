AtomicInteger count = new AtomicInteger(0);

public int getCount()
{
    return count.get();
}

public void increment()
{
    count.incrementAndGet();
}