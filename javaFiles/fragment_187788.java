@SuppressWarnings("unchecked")
static public <T> Class<? extends T> getClass(T obj)
{
    return (Class<? extends T>)obj.getClass();
}


// compiles
keyList.add(Key.get(getClass(values.get(0))));