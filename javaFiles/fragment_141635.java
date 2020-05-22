public class UStats {
    public static final String TAG = UStats.class.getSimpleName();
    @SuppressLint("SimpleDateFormat")
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("M-d-yyyy HH:mm:ss");

    public static ArrayList<String> printCurrentUsageStatus(Context context) {
        return printUsageStats(getUsageStatsList(context));
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static ArrayList<String> printUsageStats(List<UsageStats> usageStatsList) {
        HashMap<String, Integer> lastApp = new HashMap<String, Integer>();
        for (UsageStats u : usageStatsList) {
            lastApp.put(u.getPackageName(), (int) u.getLastTimeStamp());
            /*Log.d(TAG, "Pkg: " + u.getPackageName() + "\t" + "ForegroundTime: "
                    + u.getTotalTimeInForeground() + "\t" + "LastTimeStamp: " + new Date(u.getLastTimeStamp()));*/
        }
        Map<String, Integer> sortedMapAsc = sortByComparator(lastApp);
        ArrayList<String> firstApp = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedMapAsc.entrySet()) {
            String key = entry.getKey();
            //Integer value = entry.getValue();
            firstApp.add(key);
            /*System.out.println("package name: " + key + ", time " + new Date(Math.abs(value)));*/
        }

        return firstApp;
    }

    // To check the USAGE_STATS_SERVICE permission
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static List<UsageStats> getUsageStatsList(Context context) {
        UsageStatsManager usm = getUsageStatsManager(context);
        Calendar calendar = Calendar.getInstance();
        long endTime = calendar.getTimeInMillis();
        calendar.add(Calendar.MINUTE, -1);
        long startTime = calendar.getTimeInMillis();

        Log.d(TAG, "Under getUsageStateList");
        Log.d(TAG, "Range start:" + dateFormat.format(startTime));
        Log.d(TAG, "Range end:" + dateFormat.format(endTime));

        List<UsageStats> usageStatsList = usm.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, startTime, endTime);
        return usageStatsList;
    }

    // Sort the map in the ascending order of the timeStamp
    private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    @SuppressWarnings("ResourceType")
    private static UsageStatsManager getUsageStatsManager(Context context) {
        UsageStatsManager usm = (UsageStatsManager) context.getSystemService(Context.USAGE_STATS_SERVICE);
        return usm;
    }
}