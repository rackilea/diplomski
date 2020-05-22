void getUsageStatistics(long starting_time, long end_time)
{

    UsageEvents.Event currentEvent;
    List<UsageEvents.Event> allEvents = new ArrayList<>();
    HashMap<String, AppUsageInfo> map = new HashMap<String, AppUsageInfo>();

    UsageStatsManager mUsageStatsManager = (UsageStatsManager)
            getSystemService(Context.USAGE_STATS_SERVICE);

    if (mUsageStatsManager != null)
    {
        // Get all apps data from starting time to end time
        UsageEvents usageEvents = mUsageStatsManager.queryEvents(starting_time, end_time);

        // Put these data into the map
        while (usageEvents.hasNextEvent())
        {
            currentEvent = new UsageEvents.Event();
            usageEvents.getNextEvent(currentEvent);
            if (currentEvent.getEventType() == UsageEvents.Event.MOVE_TO_FOREGROUND ||
                    currentEvent.getEventType() == UsageEvents.Event.MOVE_TO_BACKGROUND)
            {
                allEvents.add(currentEvent);
                String key = currentEvent.getPackageName();
                if (map.get(key) == null)
                    map.put(key, new AppUsageInfo(key));
            }
        }

        // Traverse through each app data and count launch, calculate duration
        for (int i = 0; i < allEvents.size() - 1; i++)
        {
            UsageEvents.Event E0 = allEvents.get(i);
            UsageEvents.Event E1 = allEvents.get(i + 1);

            if (!E0.getPackageName().equals(E1.getPackageName()) && E1.getEventType() == 1)
            {
                map.get(E1.getPackageName()).launchCount++;
            }

            if (E0.getEventType() == 1 && E1.getEventType() == 2
                    && E0.getClassName().equals(E1.getClassName()))
            {
                long diff = E1.getTimeStamp() - E0.getTimeStamp();
                map.get(E0.getPackageName()).timeInForeground += diff;
            }
        }
        smallInfoList = new ArrayList<>(map.values());

        // Concatenating data to show in a text view. You may do according to your requirement
        for (AppUsageInfo appUsageInfo : smallInfoList)
        {
            // Do according to your requirement
            strMsg = strMsg.concat(appUsageInfo.packageName + " : " + appUsageInfo.launchCount + "\n\n");
        }

        TextView tvMsg = findViewById(R.id.MA_TvMsg);
        tvMsg.setText(strMsg);
    }
    else
    {
        Toast.makeText(this, "Sorry...", Toast.LENGTH_SHORT).show();
    }
}