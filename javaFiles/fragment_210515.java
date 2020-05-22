public ArrayList filterRaw(ArrayList groups)
{
    ArrayList pass = new ArrayList();
    for (int i = 0; i < groups.size(); i++)
    {
        if ((Integer)groups.get(i) >= 50) pass.add(groups.get(i));

    }
    return pass;
}