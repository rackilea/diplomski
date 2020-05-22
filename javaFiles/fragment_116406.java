public class ResultList
{
    Scanner scanner = new Scanner(System.in);
    ArrayList<Result> resultList = new ArrayList<Result>();
    AthleteList athleteList;

    public ResultList()
    {
        athleteList = new AthleteList();
    }

    void addResult()
    {
        int competetionNumber;
        System.out.print("What is the athletes competetionnumber?");
        competetionNumber = scanner.nextInt();
        scanner.nextInt();

        Athlete matched = null;
        List<Athlete> athletes = athleteList.getArrayList();
        for(int i = 0; i < athletes.size(); i++)
        {
            if(athlete.completionNumber == completionNumber)
            {
                //you found a match!!
                matched = athlete;
            }
        }

        if(matched == null)
        {
            System.out.println("No Match Found for " + completionNumber);
        }
        else
        {
            System.out.println("Found match: " + matched.toString());
        }
    }
}