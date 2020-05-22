List<String> discardedList = new ArrayList<String>();

public void readStuff() {}

public static List<String> someReaderMethod()
{
  for(int i = 0; i < workingList.size(); i++)
  {
    if(workingList.get(i).contains(someExp))
    {
      discardedList.add(workingList.get(i));
      workingList.remove(i);
    }
  }
  return discardedList;
}