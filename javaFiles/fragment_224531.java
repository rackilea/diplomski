Scanner scan = new Scanner(System.in);

    String ans = null;
    System.out.print("Enter your Birth Year: ");

    String[] sign = {"Monkey", "Rooster", "Dog", "Pig", "Rat", "Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Sheep"};
    int birthYear = scan.nextInt();
    do {

        int mod = birthYear % 12;
        ans = sign[mod];

    } while (ans == null);
    System.out.println("Your Zodiac Sign is: " + ans);