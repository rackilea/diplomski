public static void main(String[] args)
{
    String input = "1: In: ThisName (ThisName) is in this list\n" +
        "2: In: OtherName (With These) (OtherName (With These)) is in this list\n" +
        "3: In: Really Annoying (Because) Separators (Really Annoying (Because) Separators) is in this list\n" +
        "4: In: Not the Same (NotTheSame) is in this list\n" +
        "5: In: A = (B) (A = (B)) is in this list\n" +
        "6: In: A != (B) (A != B) is in this list\n";

    for (String line : input.split("\n"))
    {
        processInput(line);
    }
}


public static void processInput(String line)
{
    // Parse the relevant part from the input.
    Matcher inputPattern = Pattern.compile("(\\d+): In: (.*) is in this list").matcher(line);
    if (!inputPattern.matches())
    {
        System.out.println(line + " is not valid input");
        return;
    }
    String inputNum = inputPattern.group(1);
    String aAndB = inputPattern.group(2);

    // Check if a = b.
    Matcher aEqualsBPattern = Pattern.compile("(.*) \\(\\1\\)").matcher(aAndB);
    if (aEqualsBPattern.matches())
    {
        System.out.println("Input " + inputNum + ":");
        System.out.println("a = b = " + aEqualsBPattern.group(1));
        System.out.println();
        return;
    }

    // Check if a and b have no parentheses.
    Matcher noParenthesesPattern = Pattern.compile("([^()]*) \\(([^()]*)\\)").matcher(aAndB);
    if (noParenthesesPattern.matches())
    {
        System.out.println("Input " + inputNum + ":");
        System.out.println("a = " + noParenthesesPattern.group(1));
        System.out.println("b = " + noParenthesesPattern.group(2));
        System.out.println();
        return;
    }

    // a and b have one or more parentheses in them.
    // All you can do now is guess what a and b are.

    // There is at least one " (" in the string.
    String[] split = aAndB.split(" \\(");
    for (int i = 0; i < split.length - 1; i++)
    {
        System.out.println("Possible Input " + inputNum + ":");
        System.out.println("possible a = " + mergeParts(split, 0, i));
        System.out.println("possible b = " + mergeParts(split, i + 1, split.length - 1));
        System.out.println();
    }
}


private static String mergeParts(String[] aAndBParts, int startIndex, int endIndex)
{
    StringBuilder s = new StringBuilder(getPart(aAndBParts, startIndex));
    for (int j = startIndex + 1; j <= endIndex; j++)
    {
        s.append(" (");
        s.append(getPart(aAndBParts, j));
    }
    return s.toString();
}


private static String getPart(String[] aAndBParts, int j)
{
    if (j != aAndBParts.length - 1)
    {
        return aAndBParts[j];
    }
    return aAndBParts[j].substring(0, aAndBParts[j].length() - 1);
}