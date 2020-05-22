private static String[] playerNames = new String[] {"Messi", "Ronaldo"};
private static String[] teamNames = new String[] {"FC Barcelona", "Chelsea"};
private static String[] roleNames = new String[] {"Attacker", "Defender"};

public static void main(String[] args) {
    public List<Player> players;
    players = new ArrayList<Player>();
    players.add(new Player("Messi", "FC Barcelona", "Attacker"));
}

public Player getRandomPlayer() {
    Player player=null;
    String name = getRandomName();
    String team = getRandomTeam();
    String role = getRandomRole();
}

private String getRandomName() {
    return playerNames[new Random().nextInt(playerNames.length())];
}

private String getRandomTeam() {
    return teamNames[new Random().nextInt(teamNames.length())];
}

private String getRandomRole() {
    return roleNames[new Random().nextInt(roleNames.length())];
}