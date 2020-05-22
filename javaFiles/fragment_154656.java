@SuppressWarnings("unchecked")
public String toString()
{
    if (isEmpty())
    {
        return "[]";
    }
    else
        {
            String result = "[" + first.data;
            Node current = first.next;
        for(int i = 0; i < size-1; i++)
        {
            result += ", " + current.data;
            current = current.next;
        }
        result += "]";
        return result;
    }
}