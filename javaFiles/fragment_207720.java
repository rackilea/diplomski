public <E extends MyInterface> E[] 
    getArray(Class<E> c, MyInterface foo)
{
    int count = lumps[foo.getLumpIndex()].filelen / foo.getSize();
    E[] myArray = (E[]) Array.newInstance(c, count);
    for(int i = 0; i < count; i++)
         myArray[i] = c.newInstance();
    return myArray;
}