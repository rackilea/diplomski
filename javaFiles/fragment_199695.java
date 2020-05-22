public static int[] questionsMissed (char[] resp, char[] ans)
{
    int sizeArray = resp.length - totalCorrect (resp, ans);
    int[] missedQuestions = {};

    if (sizeArray < 1)
        return missedQuestions;

    else
    {
        missedQuestions = new int [sizeArray];
        int position = 0;
        for (int x = 0 ; x < resp.length ; x++) /* Changed number of iterations */
        {
            if (resp [x] != ans [x])
            {
                missedQuestions [position] = (x + 1);
                position = position + 1;
            }
        }
        return missedQuestions;
    }

}