String s = "aaaaaa";
Matcher m = Pattern.compile("(?=(aa))").matcher(s);
List<Integer> pos = new ArrayList<Integer>();
while (m.find())
{
    pos.add(m.start());
}
System.out.println(pos);