Scanner scan = new Scanner(System.in);
loop:
while (true) {
    String input = scan.nextLine();
    switch (input) {
        case "attack":
            System.out.println("You attacked the enemy!");
            break loop;

        case "defend":
            System.out.println("You blocked the enemy!");
            break loop;

        default:
            System.out.println("This is not an option!");
            break;
    }
}