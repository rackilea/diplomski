String seq1="ihavehashasaahasabig";
Pattern pat =Pattern.compile(".has.*?has.*?has.");
Matcher m=pat.matcher(seq1);
while (m.find())
{
    System.out.println(m.group());}