public class DestructorTheDestroyerOfWorlds
{
    private static List<Answer> correctAnswers;

    public static boolean destroyAnswers(List<Answer> userAnswers)
    {
        boolean success = true;
        for(Answer userAnswer : userAnswers) 
        {
            success &= destroyAnswer(userAnswer);
        }
        return success;
    }

    private static boolean destroyAnswer(Answer userAnswer)
    {
        for (int i = 0; i < correctAnswers.length; i++)
        {
            if (correctAnswers.get(i).idAnswer == userAnswer.idAnswer)
            {
                correctAnswers.remove(i);
                return true;
            }
        }
        return false;
    }

    public static boolean isOutOfAmmo()
    {
        return correctAnswers.isEmpty();
    }

    public static void loadUp(List<Answer> answers)
    {
        correctAnswers = answers;
    }
}