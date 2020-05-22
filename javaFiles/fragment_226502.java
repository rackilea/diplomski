public static void saveGame(Game game) {
    Game dupGame = null;
    for (Game g : savedGames) {
        if (g.name.equals(game.name)) {
            dupGame = g;
        }
    }
    if (dupGame != null) {
        savedGames.remove(dupGame );
    }
    savedGames.add(game);
}