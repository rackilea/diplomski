static String[] leafIDs(String s)
{
    List<String> sa = new ArrayList<>();
    char[] ca = new char[s.length()];
    for(int j=0, i=s.length()-1; i>=0; i--,j++)
    {
        if((ca[j] = s.charAt(i)) == '-') sa.add(new String(ca, 0, j));
    }
    sa.add(new String(ca));
    return sa.toArray(new String[sa.size()]);
}