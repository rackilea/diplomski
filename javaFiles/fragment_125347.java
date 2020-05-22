public Student getTopStudent() //this is the other method I need to create
{
    int x=0; //this will contain the highest average
    int y=0; //this will be the index in the array of the highest scoring student

    for(int i =0; i<numStudentsAdded; i++)
    {
        int currentAverage = students[i].getAverageScore(); //run the getAverageScore() on the current student
        if(x<currentAverage) // compare it to the previous high average
        {
            x=currentAverage; // replace x with new high average
            y=i; //replace the index of the highest scoring student with current index i
        }
    }
    return students[y]; // so if the fifth student had the highest score, y would be 4
}