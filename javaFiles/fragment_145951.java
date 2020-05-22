public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int yesVotes = 0;
    int noVotes = 0;
    //int quitVote = 0; // no need for this
    char vote = 'x';

    System.out
            .println("Enter 'Y' to vote yes or Enter 'N' to vote no or Enter 'Q' to quit");

    while (true) { // keeps on running until you quit
        vote = input.next().charAt(0); // for taking user input (previously you were placing it outside the loop)
        if (vote == 'Y' || vote == 'y')
            yesVotes++;
        else if (vote == 'N' || vote == 'n')
            noVotes++;
        else if (vote == 'Q' || vote == 'q')
            break;
        else
            System.out.println("Your input is invalid...Please try again");
    }

    input.close(); // to close the input stream

    System.out.println("Total yes votes: " + yesVotes);
    System.out.println("Total no votes: " + noVotes);
}