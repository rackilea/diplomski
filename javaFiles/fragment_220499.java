public class TournamentRanker {

    public class Team {
        String name;
        Integer wins;
        Team beatEm;
    }

    // Map all teams to number of wins & to team that beat them
    ArrayList<String> teams = new ArrayList<String>();
    HashMap<String, Integer> Teamwins = new HashMap<String, Integer>();
    HashMap<String, String> Whobeat = new HashMap<String, String>();

    public String[] rankTeams(String[] names, String[] lostTo) { 
        TeamComparator teamComparator = new TeamComparator();

        // Use teamComparator to sort teams.
        ...
    }

    private TeamComparator implements Comparator<String> {
        public int compare(String team1, String team2){
            // This function can now access the maps.

            // Perform the comparison here.
            ...
        }
    }
}