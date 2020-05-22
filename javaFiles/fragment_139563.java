public static void main(String[] args)
{
    System.out.println(findPassword("stack", 5));
}

private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

public static String findPassword(String solution, int length)
{
    return findPassword(solution, length, "", 0);
}

private static String findPassword(String solution, int length, String pass, int alphabetIndex)
{
    if (pass.length() == length)
    {
        if (solution.equals(pass))
            return pass;
        return "";
    }

    if (alphabetIndex < alphabet.length())
    {
        String found = findPassword(solution, length, pass + alphabet.charAt(alphabetIndex), 0);

        if (found.length() == 0)
        {
            return findPassword(solution, length, pass, alphabetIndex + 1);
        }

        return found;
    }

    return "";
}