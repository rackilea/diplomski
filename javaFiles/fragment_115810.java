public static Player getBestScore(Arena arena) {
    System.out.println(arena.getAPlayers().size());
    System.out.println(arena.getAPlayers().get(1).toString());
    int i = 0;
    Player player = null;

    // index of for loop is p
    for(int p = 0; p != arena.getAPlayers().size() - 1; i++) {

        System.out.println(arena.getAPlayers().get(p).toString());
        org.bukkit.entity.Player pla = arena.players.get(p);

        // If player's score is higher than current highscore(i)
        if(getArenaPlayer(pla).getScore() > i) {

            // Set current highscore(i) to this player's score
            i = getArenaPlayer(pla).getScore();
            player = getArenaPlayer(pla);
        }
    }
    return player;
}