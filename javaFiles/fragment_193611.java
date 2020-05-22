static String[] leafIDsSB(String s)
{
    List<String> sa = new ArrayList<>();
    StringBuilder b = new StringBuilder();
    for(int i=s.length()-1; i>=0; i--)
    {
        char c = s.charAt(i);
        if(c == '-') sa.add(b.toString());
        b.append(c);
    }
    sa.add(b.toString());
    return sa.toArray(new String[sa.size()]);
}