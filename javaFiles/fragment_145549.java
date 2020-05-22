for (int i = 0; i < tempTable.size(); i++)
{
    if ("11".equals(tempTable.get(i)))
    {
        tempTable.set(i, "1st FBS");
    }
    else if ("12".equals(tempTable.get(i)))
    {
        tempTable.set(i, "2nd FBS");
    }
    else if ("13".equals(tempTable.get(i)))
    {
        tempTable.set(i, "3rd FBS");
    }
    else
    {
        // leave as is
    }
}