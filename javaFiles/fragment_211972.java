private static int queryWeaponForHero(int hero) {
    Scanner scan = new Scanner(System.in);
    int weapon;
    while (true) {
        if(hero == 1) {
            System.out.println("Choose your weapon: 1 for Sword; 2 for Staff");
            weapon = scan.nextInt();
            if (weapon == 1 || weapon == 2) {
                break;
            } else {
                System.out.println(weapon + " is not a valid choice");
            }
        } else if(hero == 2) {
            System.out.println("Choose your weapon: 2 for Staff");
            weapon = scan.nextInt();
            if(weapon == 2) {
                break;
            }else {
                System.out.println(weapon + " is not a valid choice");
            }
        }

    }
    return weapon;
}