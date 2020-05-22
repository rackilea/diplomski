void ListMatches(List<string> ListTeam)
{
    if (ListTeam.Count % 2 != 0)
    {
        ListTeam.Add("Bye"); // If odd number of teams add a dummy
    }

    int numDays = (numTeams - 1); // Days needed to complete tournament
    int halfSize = numTeams / 2;

    List<string> teams = new List<string>();

    teams.AddRange(ListTeam); // Add teams to List and remove the first team
    teams.RemoveAt=(0);

    int teamsSize = teams.Count;

    for (int day = 0; day < numDays; day++)
    {
        Console.WriteLine("Day {0}", (day + 1));

        int teamIdx = day % teamsSize;

        Console.WriteLine("{0} vs {1}", teams[teamIdx], ListTeam[0]);

        for (int idx = 1; idx < halfSize; idx++)
        {               
            int firstTeam = (day + idx) % teamsSize;
            int secondTeam = (day  + teamsSize - idx) % teamsSize;
            Console.WriteLine("{0} vs {1}", teams[firstTeam], teams[secondTeam]);
        }
    }
}