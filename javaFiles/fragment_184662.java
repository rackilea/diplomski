boolean found = false;
Iterator<FootballClub> it = premierLeague.iterator();
int itCounter = 0;
while (it.hasNext()) {
    if ((it.next().getClubName()).equals(homeName)) {
        System.out.println("Enter number of goals scored by " + homeName + ":");
        // Scanner input = new Scanner(System.in);
        homeScore = input.nextInt();
        premierLeague.get(itCounter++).setGoalsScored(homeScore);
        again = false;
        found = true;
        break;
    }
}
if( ! found ){
    System.out.println("You must enter a valid team!");
}