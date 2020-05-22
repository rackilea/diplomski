for (int i = 0; i < name.size(); i++)
{
    for (int j = i + 1; j < name.size(); j++)   // j needs to start at i + 1 not 1.
        if (name.get(i).equals(name.get(j)))
        {
            name.remove(j);                     // You need to remove at the higher index
            name.remove(i);                     // first, because items are shifted left.
            j = j - 1;
        }
}