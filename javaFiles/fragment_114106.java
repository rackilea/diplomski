public int questionsMissed() 
{
    for (int index = 0; index < 20; index++) // Ask program to step through each element in array answers.
    {
        if (Answers[index] == 0){
            return index + 1;
        }
    }
    return 0; //If nothing works
}