/** limit on the size of the name of the group **/
private static final int GROUP_NAME_LIMIT = 128;
/** limit on the size of the counter name **/
private static final int COUNTER_NAME_LIMIT = 64;

private static final JobConf conf = new JobConf();
/** limit on counters **/
public static int MAX_COUNTER_LIMIT = 
conf.getInt("mapreduce.job.counters.limit", 120);

/** the max groups allowed **/
static final int MAX_GROUP_LIMIT = 50;