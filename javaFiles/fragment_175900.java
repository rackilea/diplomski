private void isAList(Object example)
{
    if (example != null && !((List<?>)example).isEmpty() && ((List<?>)example).get(0) instanceof String)
    {
        for (String cad : (List<String>)example)
        {
            // YOUR CODE
        }
    }
}