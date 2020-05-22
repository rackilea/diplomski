public class YourApplication extends Application
{
    public synchronized Tracker getTracker() {

        try {
            final GoogleAnalytics googleAnalytics = GoogleAnalytics.getInstance(this);
            return googleAnalytics.newTracker(R.xml.analytics);

        }catch(final Exception e){
            Log.e(TAG, "Failed to initialize Google Analytics V4");
        }

        return null;
    }
}