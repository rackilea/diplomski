public static void getQ()
{
    questionNum = 0; // set to 0
    System.out.println("What is the First Question?");
    questions[questionNum] = kb.nextLine();
    getAns(); // still 0 
    questionNum ++; // too late
    ...
}