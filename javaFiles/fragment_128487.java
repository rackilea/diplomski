private ProgressDialog progressDialog;
private ImageView imageView;
private ArrayList<String> imagesURLs = new ArrayList<>();
private String firstImgURL = "";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_download_images);

    imageView = findViewById(R.id.imageView);

    new FetchImageLogo().execute();
}

private class FetchImageLogo extends AsyncTask<Void, Void, Void> {
    //Bitmap bitmap;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("LOGO");
        progressDialog.setMessage("Logo Çekiliyor...");
        progressDialog.setIndeterminate(false);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        String yemekURL = "http://www.planecrashinfo.com/recent.htm";

        try {
            imagesURLs = getAllImages(yemekURL);

            // Can not get images URLs
            if (imagesURLs == null) return null;
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Display the first image...
        // you have to put your code in runOnUiThread() to reach UI components
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Glide.with(MainActivity.this)
                        .load(firstImgURL)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                        .into(imageView);
            }
        });


        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < imagesURLs.size(); i++) {
            // ToDo: you need to create [RecyclerView] to display all images
            /*runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Glide.with(MainActivity.this)
                            .load(imagesURLs.get(i))
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .skipMemoryCache(true)
                            .into(imageView);
                }
            });*/

            stringBuilder.append("img").append(String.valueOf(i + 1)).append(": ")
                    .append(imagesURLs.get(i)).append("\n");
        }

        // See -> Logcat
        Log.d("Debug_Images", stringBuilder.toString());

        return null;
    }

    ArrayList<String> getAllImages(String url) {
        Document doc;

        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            // ToDo "Can not connect the URL, Make sure that the URL starts with [http://...]"
            return null;
        }

        // Get the first image URL
        Element link = doc.select("img").first();
        firstImgURL = link.attr("abs:src");

        // Get all images URLs
        Elements media = doc.select("[src]");
        for (Element img : media) {
            if (img.tagName().equals("img")) {
                // Add images url to the list
                imagesURLs.add(img.attr("abs:src"));
            }
        }

        return imagesURLs;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        /*logo_layout = (LinearLayout) findViewById(R.id.logo_layout);
        ImageView img_logo = (ImageView) findViewById(R.id.img_logo);
        logo_layout.setVisibility(View.VISIBLE);
        img_logo.setImageBitmap(bitmap);*/
        progressDialog.dismiss();
    }
}