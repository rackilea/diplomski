public static void main(String[] args)
{
    new Main().printDiamond("HOUSE");
}

private void printDiamond(String word)
{
    for (int i = 0 ; i < word.length(); i++)
    {
        printPart(word, i);
    }

    for (int i = word.length() - 2; i >= 0; i--)
    {
        printPart(word, i);
    }
}

private void printPart(String word, int i)
{
    space(word.length() - (i + 1));
    System.out.print(word.charAt(i));
    if (i > 0)
    {
        space((i * 2) - 1);
        System.out.print(word.charAt(i));
    }
    space(word.length() - (i + 1));
    System.out.println();
}

private void space(int i)
{
    for (int j = 0; j < i; j++)
    {
        System.out.print(" ");
    }
}