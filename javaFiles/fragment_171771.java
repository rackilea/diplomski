public static boolean checkInputs(String input, int questions)
{
    boolean checkInputs = true; // intially true, false if proven otherwise
    if (input.length() == questions) // if proper # of answers to # of questions
    {
        for (int question = 0; question < questions; question++)
        {
            int letter = input.charAt(question);
            if (!(letter == 'A' || letter == 'B' || letter == 'C' || letter == 'D' || letter == 'X'))
            {
                checkInputs = false;
            }
        }
    }
    else
    {
        return false; // # of answers != # of questions, so return false
    }

    return checkInputs;
}