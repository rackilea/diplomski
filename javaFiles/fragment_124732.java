public static int presentQuestion(Question q, Scanner in)
{
    // Display the first question
    q.display();
    System.out.println("Your answer:");
    String response = in.nextLine();
    // Check whether the response was correct
    // If so, print "true" and return 1
    // Otherwise, print "false" and return 0
    boolean outcome = q.checkAnswer(response);
    System.out.println(outcome);
    if (outcome) {
        return 1;
    } else {
        return 0;
    }
}