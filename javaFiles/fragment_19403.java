public DSAHashTable(int maxSize)
{
    if (maxSize <= 0)
        throw new IllegalArgumentException("Illegal max size: " + maxSize);
    this.maxSize = maxSize;
    ...
}