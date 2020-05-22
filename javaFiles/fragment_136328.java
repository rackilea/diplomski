List<String> weeks = new ArrayList<String>();
weeks.add(1 + " " + 1958);
weeks.add(32 + " " + 2007);
weeks.add(32 + " " + 1999);

Collections.sort(weeks, new Comparator<String>()
{
  public int compare(String o1, String o2)
  {
    int y1 = Integer.parseInt(o1.substring(o1.indexOf(" ") + 1));
    int y2 = Integer.parseInt(o2.substring(o2.indexOf(" ") + 1));
    if (y1 == y2)
    {
      int w1 = Integer.parseInt(o1.substring(0, o1.indexOf(" ")));
      int w2 = Integer.parseInt(o2.substring(0, o2.indexOf(" ")));
      return w1 - w2;
    }
    return y1 - y2;
  }
});

System.out.println("weeks = " + weeks);