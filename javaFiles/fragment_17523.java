public static void roundRobin2(ArrayList<Jobs> c, int startSize)
{
    double counter = 0;
    double compTime = 0;
    while (! c.isEmpty())
    {
        System.out.println(c);
        for (Jobs jobs : c)
        {
            if (jobs.jobTime >= 2)
            {
                jobs.jobTime -= 2;
                counter += 2;
            }
            else
            {
                jobs.jobTime -= 1;
                counter += 1;
            }
            if (jobs.jobTime == 0)
            {
                compTime += counter;
            }
        }
        for (Iterator<Jobs> jobsIter = c.iterator(); jobsIter.hasNext(); )
        {
            Jobs jobs = jobsIter.next();
            if (jobs.jobTime == 0)
            {
                jobsIter.remove();
            }
        }
    }
    System.out.println("\n\nAverage completion times: " + compTime + "/" + startSize + " = " + (compTime / startSize));
}