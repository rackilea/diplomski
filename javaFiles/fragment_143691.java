public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new RssReaderAsyncTask(new RSSCallBack() {

            @Override
            public void success(RSSReader rssReader) {
                // TODO That Should run on UI Thread if you update UI
                // for example
                final RSSReader reader = rssReader;
                // you can use runOnUiThread or Handler update UI
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Toast 
                        Toast.makeText(MainActivity.this, reader.getTitleList().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void failed() {
                // TODO That Should run on UI Thread if you update UI
                Log.e("RSS", "failed");
            }
        }).execute("");

    }

    private class RssReaderAsyncTask extends AsyncTask<String, Integer, Integer> {
        private RSSCallBack rssCallBack;

        public RssReaderAsyncTask(RSSCallBack rssCallBack) {
            this.rssCallBack = rssCallBack;
        }

        @Override
        protected Integer doInBackground(String... params) {
            // TODO
            try {
                RSSReader reader = new RSSReader();
                rssCallBack.success(reader);
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                rssCallBack.failed();
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                rssCallBack.failed();
                e.printStackTrace();
            }
            return null;
        }

    }

    private interface RSSCallBack {
        void success(RSSReader rssReader);

        void failed();
    }

    public class RSSReader {
        // Lists to store headlines, descriptions & images
        String url = "http://www.nu.nl/rss/Algemeen";
        List<String> titleList;
        List<String> descriptionList;
        List<String> imageList;

        public RSSReader() throws MalformedURLException, IOException {

            titleList = readRSS(url, "<title>", "</title>");
            descriptionList = listFilter(readRSS(url, "<description>", "</description>"), "&amp;nbsp;", "");
            imageList = readRSS(url, "<enclosure url \"", "\" length=\"0\" type=\"image/jpeg\"</enclosure>");

        }

        public List<String> readRSS(String feedUrl, String openTag, String closeTag)
                throws IOException, MalformedURLException {

            URL url = new URL(feedUrl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String currentLine;
            List<String> tempList = new ArrayList<String>();
            while ((currentLine = reader.readLine()) != null) {
                Integer tagEndIndex = 0;
                Integer tagStartIndex = 0;
                while (tagStartIndex >= 0) {
                    tagStartIndex = currentLine.indexOf(openTag, tagEndIndex);
                    if (tagStartIndex >= 0) {
                        tagEndIndex = currentLine.indexOf(closeTag, tagStartIndex);
                        tempList.add(currentLine.substring(tagStartIndex + openTag.length(), tagEndIndex) + "\n");
                    }
                }
            }
            if (tempList.size() > 0) {
                //TODO you do not check it
                tempList.remove(0);
            }
            return tempList;
        }

        public List<String> getDesciptionList() {
            return descriptionList;
        }

        public List<String> getTitleList() {
            return titleList;
        }

        public List<String> getImageList() {
            return imageList;
        }

        public List<String> listFilter(List<String> tempList, String require, String replace) {
            // Creates new List
            List<String> newList = new ArrayList<String>();
            // Loops through old list and checks for the 'require' variable
            for (int i = 0; i < tempList.size(); i++) {
                if (tempList.get(i).contains(require)) {
                    newList.add(tempList.get(i).replace(require, replace));
                } else {
                    newList.add(tempList.get(i));
                }
            }
            return newList;
        }

    }
}