String word = "HOUSE";
String SPACES = "              ";
int len = word.length();

for (int i = 0 ; i < len; i++)
{
    System.out.print(SPACES.substring(0, len - (i + 1))); //print left padding spaces
    System.out.print(word.charAt(i)); //print left/middle character
    if (i > 0) //we don't want to do this on run 0 because there we only need to print one character in the middle (H)
    {
        System.out.print(SPACES.substring(0, (i * 2) - 1)); //print middle padding spaces
        System.out.print(word.charAt(i)); //print right character
    }
    System.out.println(SPACES.substring(0, len - (i + 1))); //optional: print right padding
}

for (int i = len - 2; i >= 0; i--) //start at len - 2. -1 because arrays start at 0 and -1 because we don't want to print the last character (E) again
{
    System.out.print(SPACES.substring(0, len - (i + 1)));
    System.out.print(word.charAt(i));
    if (i > 0)
    {
        System.out.print(SPACES.substring(0, (i * 2) - 1));
        System.out.print(word.charAt(i));
    }
    System.out.println(SPACES.substring(0, len - (i + 1)));
}