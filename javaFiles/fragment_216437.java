public void read_votes(Scanner stdin, int votes[])
{
    //for (int i = 0; i < votes.length; i++)
    //   votes[i] = stdin.nextInt();


    for(int i = 0; i < votes.length; ++i)
    {
        votes[i] = stdin.nextInt();
    }
}

public void read_candidates(Scanner stdin, String candidates[])
{
    //for (int i = 0; i < votes.length; i++)
    //   votes[i] = stdin.nextInt();

    stdin.nextLine();
    for(int i = 0; i < candidates.length; ++i)
    {
        candidates[i] = stdin.nextLine();
    }
}