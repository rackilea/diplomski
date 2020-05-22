private static int queryHero() {
    Scanner scan = new Scanner(System.in);
    int hero;
    while (true) {
        System.out.println("Choose your hero: 1 for Warrior, 2 for Mage");
        hero = scan.nextInt();
        if(hero == 1 || hero == 2) {
            break;
        } else {
            System.out.println(hero + " is not a valid choice");
        }
    }
    return hero;
}