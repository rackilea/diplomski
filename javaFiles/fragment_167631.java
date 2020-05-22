import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FixtureGen 
{
    class Fixture
    {
        public Fixture(String teamA, String teamB)
        {
            this.teamA = teamA;
            this.teamB = teamB;
        }

        String teamA;
        String teamB;

        public String toString()
        {
            return teamA +" vs. "+teamB;
        }
    }

    public static void main(String args[])
    {
        FixtureGen gen = new FixtureGen();

        String[] teams = {"Spurs","Chelsea","Arsenal","Fulham","QPR","Palace"}; 
        List<String> teamList = Arrays.asList(teams);
        List<Fixture> fixtures = new ArrayList<Fixture>();

        for (String team : teamList)
        {
            fixtures.addAll(gen.getHomeFixtures(team, teamList));
        }

        for (Fixture fixture : fixtures)
        {
            System.out.println(fixture.toString());
        }
    }

    private  List<Fixture> getHomeFixtures(String team, List<String> teamList)
    {
        List<Fixture> fixtures = new ArrayList<Fixture>();
        Fixture fixture = null;
        for (String aTeam : teamList)
        {
            if (team != null && !team.equals(aTeam))
            {
                fixture = new FixtureGen.Fixture(team, aTeam);
                fixtures.add(fixture);
            }
        }
        return fixtures;
    }   
}