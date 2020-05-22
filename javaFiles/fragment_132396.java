public static char getGrade(int x)
{
    if((x>=90) && (x<=100))
        return 'A';
    if((x>=80) && (x<=89))
        return 'B';
    if((x>=70) && (x<=79))
        return 'C';
    if((x>=65) && (x<=69))
        return 'D';
    else
        return 'F';
}