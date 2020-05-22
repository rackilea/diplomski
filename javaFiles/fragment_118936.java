String patternString = "^(?=[^B]*+B)(?=[^T]*+T)(?=[^L]*+L)";
String[] dictionary = {"AL", "BAL", "BAK", "LABAT", "TAL", "LAT", "BALAT", "LA", "AB", "LATAB", "TAB"};
for (int i=0; i<dictionary.length; i++)
{
    Pattern p = Pattern.compile(patternString);
    Matcher m = p.matcher(dictionary[i]);
    if(m.find())
    {
        System.out.println("Match: " + dictionary[i]);
    }
}