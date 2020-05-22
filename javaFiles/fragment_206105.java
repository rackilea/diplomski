public class SingleSummonerBasicDTO
{
    public String name;
    public String tier;
    public String queue;
    public List<SingleSummonerBasicDTOEntry> entries;

    @Override
    public String toString() {
        String toString = "\nSingleSummonerBasicDTO: " + name + " " + tier + " " + queue;
        for (SingleSummonerBasicDTOEntry entry : entries) {
            toString += "\n" + entry.toString();
        }
        return toString;
    }

    public static class SingleSummonerBasicDTOEntry
    {
        public String playerOrTeamId;
        public String playerOrTeamName;
        public String division;
        public int leaguePoints;
        public int wins;
        public int losses;
        public boolean isHotStreak;
        public boolean isVeteran;
        public boolean isFreshBlood;
        public boolean isInactive;

        @Override
        public String toString() {
            return "Entry: " + playerOrTeamId + " " + playerOrTeamName + " " + division + " " + leaguePoints + " " + wins + " " + 
                    losses + " " + isHotStreak + " " + isVeteran + " " + isInactive;
        }
    }