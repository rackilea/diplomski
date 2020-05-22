Collections.sort(records, new Comparator<List<String>>()
{
  public int compare(List<String> o1, List<String> o2)
  {
    //Simple string comparison here, add more sophisticated logic if needed.
    return o1.get(1).compareTo(o2.get(1));
  }
})