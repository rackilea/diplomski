public static int questionAsk(IntQuestion question)
{
    Scanner scan = new Scanner (System.in);
    System.out.print (question.toString() +"\n");
    System.out.print ("Answer: ");
    return scan.nextInt();
}
    public static String questionAsk(StringQuestion question)
{
    Scanner scan = new Scanner (System.in);
    System.out.print (question.toString() +"\n");
    System.out.print ("Answer: ");
    return scan.nextLine();
}