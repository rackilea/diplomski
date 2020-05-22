// here come all your variable declarations 

// declare the counters
int hockeyCounter = 0;
int tinaCounter = 0;
int catsCounter = 0;
int startrekCounter = 0;

// no need to redeclare the keyboard all the time, just once is enough
Scanner keyboard = new Scanner(System.in);

for (int i = 0; i < 4; i++) {
    System.out.println("Which Event would you like to purchase a ticket for?");
    System.out.println("1. Hockey Game 2. Tina Turner Concert \n"
                    + "3. Cats Play 4. Star Trek Convention");
    int input = keyboard.nextInt();
    System.out.println("Please enter your first and last name");
    String name = scan.nextLine();

    switch (input) {
      case 1: Hockey_Game[hockeyCounter++] = name; break;
      case 2: Turner_Concert[tinaCounter++] = name; break;
      case 3: Cats_Play[catsCounter++] = name; break;
      case 4: StarTrek_Convention[startrekCounter++] = name; break;
      default: System.out.println(input + " is not a valid input");
    }
}