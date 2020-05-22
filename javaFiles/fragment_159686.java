while(true)
{
    final int oldCount = count.get();
    if(oldCount >= VALUE)
        break;
    if(count.compareAndSet(oldCount, oldCount + 1))
        break;
}