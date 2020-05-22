while (domainDailyData.size() > 0)
{
    String domainAndApps1 = domainDailyData.get(0);
    // your logic
    Iterator<String> it1 = domainDailyData.iterator();
    while(it1.hasNext())   // remove the counted domain/apps
    {
        String domainAndApps2 = it1.next();
        if(domainAndApps1.equals(domainAndApps2))
        {
            it1.remove();
        }
    }
}