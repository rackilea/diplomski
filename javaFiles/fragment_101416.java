for(int i=0; i < numQuestions; i ++)
{
    if (questions[i] instanceof DoubleQuestions)
            {
                DoubleQuestions temp = (DoubleQuestions) questions[i];
                temp.doubleAverage();
            System.out.println();
            }
}