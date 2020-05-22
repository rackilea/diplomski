public void removeLine(String ln)
{
  //loop through lineList
  for (int i = 0; i < lineList.size(); /**/)
  {
    //check if match is found
    if (lineList.get(i).equals(ln))
    {
      //remove element at i
      lineList.remove(i);
      continue;
    }

    ++i;
  }
}