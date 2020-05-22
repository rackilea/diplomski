String guess;
int numTickets;
int counter;
Scanner in = new Scanner(System.in);

//output
System.out.println("How many tickets would you like to buy?");
numTickets = Integer.parseInt(in.nextLine());
Random rand = new Random();
for (counter = 0; counter < numTickets; counter++) {
    System.out.println("Please enter your three numbers (e.g. 123): ");
    guess = in.nextLine();
    int randNum = rand.nextInt(1000); 
    String randNumb = String.format("%03d", randNum);
    char ch1 = randNumb.charAt(0);
    char ch2 = randNumb.charAt(1);
    char ch3 = randNumb.charAt(2);

    if (ch1 == guess.charAt(0) && ch2 == guess.charAt(1) && ch3 == guess.charAt(2)) {
        System.out.print("Winner: " + randNumb);
        System.out.print("Congratulations, both pairs matched. /n");
    } else if (ch3 == guess.charAt(2) && ch2 == guess.charAt(1)) {
        System.out.print("Winner: " + randNumb);
        System.out.print("Congratulations, the end pair matched.");
    } else if (ch1 == guess.charAt(0) && ch2 == guess.charAt(1)) {
        System.out.print("Winner: " + randNumb);
        System.out.print("Congratulations, the first pair matched.");
    } else {
        System.out.print("The Correct Number: " + randNumb);
    }
    System.out.println("\t Sorry, no matches,  You only had");
    System.out.println("\t one chance out of 100 to win anyway.");

}