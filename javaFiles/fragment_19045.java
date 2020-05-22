long end_time = System.currentTimeMillis();
    long start_time = end_time - (1000*60*60);

    getUsageStatistics(start_time, end_time);

    end_time =  start_time;
    start_time = start_time - hour_in_mil;

    getUsageStatistics(start_time, end_time);