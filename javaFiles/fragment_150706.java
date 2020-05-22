class Team
{
    private Set<Player> teamMembers = null;

    public Team()
    {
        teamMembers = new HashSet<>();
    }

    public void addPlayer(Player p)
    {
        teamMembers.add(p);
    }

    //And so on...
}