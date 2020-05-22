Iterator it = scheduledJobs.iterator();
while(it.hasNext())
{
    if(sameJob(it.next())) // Implement sameJob 
        it.remove();
}