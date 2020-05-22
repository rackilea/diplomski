public class Casino {
    private static String player = "";

    public static String player() {
        if (player.equals("")) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter your name : ");
            this.player = sc.nextLine();;
        }
        return player;
    }
}