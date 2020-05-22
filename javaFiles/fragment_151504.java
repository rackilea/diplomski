do {
        play = keyboard.nextLine();
        if (play.equals("y")){
}
        else {
            int count = 0, wins = 0, losts = 0, ties = 0;
            System.out.println("Games played: " + count);
            System.out.println("Wins for you: " + wins);
            System.out.println("Wins for me: " + losts);
            System.out.println("Tied games: " + ties);
        }
        } while (play.equals("y"));