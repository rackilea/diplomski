public class SportsClub
{
    public static void main(String[] args)
    {
        //Create a team without any branches
        Team myTeam = new Team("Southpaws", "South");

        //Create a new Branch without any players
        Branch myBranch = new Branch();

        //Add myBranch to myTeam
        myTeam.getBranches().add(myBranch);

        //Create a new player
        Player myPlayer = new Player("Bob", "Center", 120, 3);

        //Add myPlayer to myBranch (and therefore myTeam)
        myBranch.getPlayers().add(player);
    }
}


public class Team
{
    private String clubName;
    private String preName;
    private List<Branch> branches;

    public Team(String clubName, String preName)
    {
        this.clubName = clubName;
        this.preName = preName;
        branches = new ArrayList<Branch>();
    }

    public String getClubName() { return clubName; }
    public String getPreName() { return preName; }
    public List<Branch> getBranches() { return branches; }

    public void setClubName(String clubName) { this.clubName = clubName; }
    public void setPreName(String preName) { this.preName = preName; }
    public void setBranches(List<Branch> branches) { this.branches = branches; }
}

public class Branch
{
    private List<Player> players = new ArrayList<Player>();

    public Branch() {}

    public List<Player> getPlayers() { return players; }
    public void setPlayers(List<Player> players) { this.players = players; }
}

public class Player
{
    private String name;
    private String pos;
    private Integer salary;
    private Integer number;

    public Player(String name, String pos, Integer salary, Integer number)
    {
        this.name = name;
        this.pos = pos;
        this.salary = salary;
        this.number = number;
    }

    public String getName() { return name; }
    public String getPos() { return pos; }
    public Integer getSalary() { return salary; }
    public Integer getNumber() { return number; }

    public void setName(String name) { this.name = name; }
    public void setPos(String pos) { this.pos = pos; }
    public void setSalary(Integer salary) { this.salary = salary; }
    public void setNumber(Integer number) { this.number = number; }
}