final List<String> list = new ArrayList<String>();
final Collator col = Collator.getInstance();

for (char c = '!'; c < '~'; c++)
{
  list.add(c+"");
}

Collections.sort(list, col);
System.out.println(list);