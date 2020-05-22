private static int queryTravelOptionForHero(int hero) {
    Scanner scan = new Scanner(System.in);
    int travelOption;
    while (true) {
        if (hero == 1) {
            System.out.println("Choose your travel option: 1 for Horse");
            travelOption = scan.nextInt();
            if (travelOption == 1) {
                break;
            } else {
                System.out.println(travelOption + " is not a valid choice");
            }
        } else if (hero == 2) {
            System.out.println("Choose your travel option: 1 for Horse; 2 for Teleportation");
            travelOption = scan.nextInt();
            if (travelOption == 1 || travelOption == 2) {
                break;
            } else {
                System.out.println(travelOption + " is not a valid choice");
            }
        }
    }
    return travelOption;
}