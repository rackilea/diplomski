public int get(int field)
{
    complete();
    return internalGet(field);
}

protected final int internalGet(int field)
{
    return fields[field];
}