public T getRootData() throws EmptyTreeException
{
    if (isEmpty())
        throw new EmptyTreeException();
    else
        return root.getData();
}