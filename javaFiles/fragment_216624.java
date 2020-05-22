class MyComparator implements Comparator<String>
{
  @Override
  public int compare(String s1,
                     String s2)
  {
    return (s1.substring(3, 5).compareTo(s2.substring(3, 5)));
  }
}

myList.sort(new MyComparator());