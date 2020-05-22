public <E extends MyInterface> E[] 
    getArray(Class<E> c, int size, int index)
{
    int count = lumps[index].filelen / size;
    E[] myArray = (E[]) Array.newInstance(c, count);
    for(int i = 0; i < count; i++)
         myArray[i] = c.newInstance();
    return myArray;
}