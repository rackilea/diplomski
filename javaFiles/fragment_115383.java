final Pattern p=Pattern.compile(".*BAL=\\s([\\d,]+(?=/)).*");
final Matcherm m = p.matcher(text);
if(m.find())
    return m.group(1);
else
 return "";