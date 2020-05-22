public class AnalyticsHelper {

    private static HashMap<TrackerName, Tracker> sTrackers = new HashMap<TrackerName, Tracker>();

    public static synchronized Tracker getTracker(Context context, TrackerName trackerId) {
        if (!sTrackers.containsKey(trackerId)) {

            GoogleAnalytics analytics = GoogleAnalytics.getInstance(context);
            Tracker t = null;

            switch (trackerId) {
                case APP_TRACKER:
                    t = analytics.newTracker(R.xml.analytics_app_tracker);
                    break;
            }

            sTrackers.put(trackerId, t);
        }
        return sTrackers.get(trackerId);
    }

    public enum TrackerName {
        APP_TRACKER, // App specific tracker ID
    }
}