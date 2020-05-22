List<String> removedStrings = new ArrayList<String>();
for(int i = 0; i < list.size(); i++)
{
    if(list.get(i).length == wordLength)
    {
        removedStrings.add(list.remove(i));
    }
}