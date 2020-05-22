String s = "And condition 1 here and tbl.col2 like '%Test' AND tbl.col3 >='2018-12-12' And tbl.col4 Like 'what\\'s this'";

s = s.trim();
s = s.substring(3).trim();

boolean exclude = false;

s = s + " and";

String str = "";

for(int i = 0; i < s.length()-3; i++)
{
    if( s.charAt(i) == '\'' && !(s.charAt(i-1) == '\\') )
    {
        exclude = !exclude;
    }

    if((!s.substring(i, i+3).equalsIgnoreCase("and") || exclude) && (i != s.length()-4))
    {
        str += s.charAt(i);
    }
    else
    {
        System.out.println(str);
        str = "";
        i += 3;
    }
}