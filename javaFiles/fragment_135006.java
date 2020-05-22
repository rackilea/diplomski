public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    // List of NyTimes topics
    private String[] topics = { "world", "politics" };

    // !!! Do NOT store this in your app...  !!!
    private static final String API_KEY = "XXXXX";

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private String getURL(String apiKey, String topic) { 
        return String.format(
            "https://api.nytimes.com/svc/topstories/v2/%s.json?api-key=%s",
        topic, apiKey);
    }

    @Override
    public int getCount() {
        return topics.length; // Assuming each fragment goes to NyTimes
    }

    @Override
    public Fragment getItem(int position) {
        final String url = getURL(topics[position], API_KEY);

        // Call the other constructor
        return  new NyTimesFragment(url);
    } // done... no if statements.