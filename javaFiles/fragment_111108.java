String LongestWord(String a)
{
    int lw=0;
    int use;
    String lon="";
    while (!(a.isEmpty()))
    {
        a=a.trim();
        use=a.indexOf(" ");
        if (use<0)
        {
            break;
        }
        String cut=a.substring(0,use);
        if(cut.length()>lw)
        {
            lon=cut;
        }
        lw=lon.length();
        a=a.substring(use+1); // cut the word instead of doing harmful replacement
    }
    return lon;
}