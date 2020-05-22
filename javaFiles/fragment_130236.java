class PlayerInput {

    private final Scanner scanner;

    PlayerInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getCount() {
        int count;
        do {
            System.out.println("How Many Players? ");
            count = scanner.nextInt();
        } while (count < 2 || count > 8);
        return count;
    }

    public List<Player> inputPlayers(int count) {
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            System.out.println("Enter Name: ");
            String name = scanner.nextLine();
            int balance = 1500;
            int position = 0;
            players.add(new Player(name, balance, position));
        }
        return players;
    }
}