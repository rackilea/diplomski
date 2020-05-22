abstract class Team {
    // if there is a sensible default return then use it and the class needn't be abstract
    abstract List<String> getPlayers(); 
}

class BlueTeam extends Team {
    private final List<String> players = new ArrayList<>();

    @Override
    List<String> getPlayers() {
        return players;
    }
}