public static void main(String[] args) {

        Random rand = new Random();
        int los = rand.nextInt(11);
        int liczbaGraczy;  // number of players

        Scanner scan7 = new Scanner(System.in); // zamknac
        System.out.println("Type number of players");

        do {
            while (!scan7.hasNextInt()){
                System.out.println(" Type number of players :");
                scan7.next();
            }
            liczbaGraczy = scan7.nextInt();
        }while (liczbaGraczy < 0);


        System.out.println("Number of players :"+liczbaGraczy);
}