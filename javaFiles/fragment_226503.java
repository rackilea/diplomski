public class DB {

    private static Map<String,Game> savedGames = new HashMap<>();

    /**
     * Saves the passed member into the database.
     * 
     * @param game
     *            , the member to be saved.
     */
    public static void saveGame(Game game) {
        savedGames.put(game.name.toLowerCase(), game);
    }
}