String sentence = "";
StringBuilder sb = new StringBuilder(sentence.length());
Scanner input = new Scanner(System.in);

System.out.println("Enter a sentence: ");
sentence = input.nextLine();
/*
 * \\s (match whitespace character)
 * (<?g1> (named group with name g1)
 * \\w{6,}) (match word of length 6) (end of g1)
 * | (or)
 * (?<g2> (named group with name g2)
 * \\S+) (match any non-whitespace characters) (end of g2)
 */
Pattern pattern = Pattern.compile("\\s(?<g1>\\w{6,})|(?<g2>\\S+)");
Matcher matcher = pattern.matcher(sentence);

//check if the matcher found a match
while (matcher.find())
{
    //get value from g1 group (null if not found)
    String g1 = matcher.group("g1");
    //get value from g2 group (null if not found)
    String g2 = matcher.group("g2");

    //if g1 is not null and is not an empty string
    if (g1 != null && g1.length() > 0)
    {
        //get the first character of this word and upercase it then append it to the StringBuilder
        sb.append(Character.toUpperCase(g1.charAt(0)));
        //sanity check to stop us from getting IndexOutOfBoundsException
        //check if g1 length is more than 1 and append the rest of the word to the StringBuilder
        if(g1.length() > 1) sb.append(g1.substring(1, g1.length()));
        //append a space
        sb.append(" ");
    }
    //we only need to check if g2 is not null here
    if (g2 != null)
    {
        //g2 is smaller than 5 characters so just append it to the StringBuilder
        sb.append(g2);
        //append a space
        sb.append(" ");
    }
}
System.out.println("Original Sentence: " + sentence);
System.out.println("Modified Sentence: " + sb.toString());