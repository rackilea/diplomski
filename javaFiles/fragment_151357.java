public static String toString(Object[] values)
{
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < values.length; i++)
    {
        if (i != 0)
            sb.append(", ");
        sb.append(values[i].toString());
    }
    return sb.toString();
}