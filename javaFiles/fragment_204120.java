public E pop()
{
    if(isEmpty())
    {
        throw new EmptyStackException();
    }
    else
        {
            return elementData[--size];
    }

}