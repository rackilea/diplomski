public static String examGrade(String ansKey, String studentAnswers)
{
    //Now only go up to the answer key length
    for(int i = 0; i < ansKey.length(); i++)
    {
        //shift the index we are checking the student answers by 1
        int j = i + 1;
        if(ansKey.charAt(i) == studentAnswers.charAt(j))
            score += 2;
        else if(studentAnswers.charAt(j) == ' ')
            score += 0;
        else
            score -= 1;
    }
}