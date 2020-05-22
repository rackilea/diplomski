if (index < 0)
{
    // No need for a separate variable
    throw new IndexOutOfBoundsException();
}

// No need for an else block
ListIterator iterator = listIterator();
Object current = null;
for (int i = 0; i <= index; i++)
{
    // Note: assuming you expose the size(), you could check this up front...
    if(!iterator.hasNext())
    {
        throw new IndexOutOfBoundsException();
    }
    current = iterator.next();
}
iterator.remove();
return current;