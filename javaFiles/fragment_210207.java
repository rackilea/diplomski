public static Player findPlayer(String playerName) {
    Pattern nameRegex = Pattern.compile(Pattern.quote(playerName), Pattern.CASE_INSENSITIVE);
    Player foundPlayer = null;
    for (Player player : players) {
        if (nameRegex.matcher(player.toString()).find()) {
            if (foundPlayer != null)
                throw new IllegalArgumentException("Multiple player matches name: " + playerName);
            foundPlayer = player;
        }
    }
    return foundPlayer; // returns null if not found
}