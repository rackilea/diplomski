if (Grade_Average > 100)
{
    System.out.println("Not possible, you got more than 100 points you cheater!");
}
else if (Grade_Average >= 90)
{
    System.out.println( " Your average test score is " + Grade_Average );
    System.out.println( "Your letter grade is an A." );
}
else if (Grade_Average >= 80)
{
    // do stuff
}
// moar stuff!!11!one!
else if (Grade_Average >= 0)
{
    System.out.println( " Your average test score is " + Grade_Average );
    System.out.println( "Your letter grade is a F." );
}
else
{
    System.out.println("Error! I cannot grade your score!");
}