public Student getMostImprovedStudent()
{
    Student mostImproved = students[0];
    int biggest = student[i].getExamRange();
    for(int i = 1; i < students.length; i++) {
        if(students[i].getExamRange() > biggest) {
            mostImproved = students[i];
            biggest = students[i].getExamRange();
        }
    }
    return mostImproved;
}