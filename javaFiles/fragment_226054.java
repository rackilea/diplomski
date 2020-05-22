Iterator<String> iterator1 = list1.iterator();
Iterator<String> iterator2 = list2.iterator();

while (iterator1.hasNext() || iterator2.hasNext())
{
    if (iterator1.hasNext())
    {
        result.add(iterator1.next());
    }
    if (iterator2.hasNext())
    {
        result.add(iterator2.next());
    }
}