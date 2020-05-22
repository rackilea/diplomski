public static void main(String[] args)
    {
        Scanner numPlayers = new Scanner(System.in);
        ArrayList<Player> playerList = new ArrayList<>();
        int input = numPlayers.nextInt();

        for (int i = 0; i < input; i++){
            System.out.println("what is player " + (i + 1) + " name?");
            String playerName = numPlayers.next();
            playerList.add(new Player(playerName));
        }

    }