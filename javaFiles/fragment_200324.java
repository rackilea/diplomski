final int EVENT_COUNT = 4;
final String[] EVENTS = { "Hockey Game", "Tina Turner Concert", 
                          "Cats Play", "Star Trek Convention" };
final int[] LIMITS = { 10, 5, 3, 3 };

String[][] buyers = new String[EVENT_COUNT][];
int[] counters = new int[EVENT_COUNT];

for (int i = 0; i < EVENT_COUNT; i++) {
    buyers[i] = new String[LIMITS[i]];
}

final int CUSTOMER_COUNT = 4;
Scanner keyboard = new Scanner(System.in);

for (int i = 0; i < CUSTOMER_COUNT; i++) {
    System.out.println("Which Event would you like to purchase a ticket for?");
    for (int j = 0; j < EVENT_COUNT; j++) {
        System.out.print((j+1) + ". " + EVENTS[j] + " ");
    }
    System.out.println();
    int input = keyboard.nextInt();

    if (input < 1 || input > EVENT_COUNT) {
        System.out.println(input + " is not a valid choice");
        i--;
    } else if (counters[input-1] >= LIMITS[input-1]) {
        System.out.println(EVENTS[input-1] + " is sold out!");
        i--;
    } else {                
        System.out.println("Please enter your first and last name");
        buyers[input-1][counters[input-1]++] = scan.nextLine();
    }
}