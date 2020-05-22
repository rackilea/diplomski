@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    context = this;
    setContentView(R.layout.main);
    findViewById(R.id.buttonRepairSkin).setOnClickListener(
            new OnClickListener() {

                @Override
                public void onClick(View v) {
                    showInstallableSkins();
                }

            });
    findViewById(R.id. imageView2).setOnClickListener(
        new OnClickListener() {
             @Override
             public void onClick(View v) {
                 Log.d(getClass().getSimpleName(), "in onClick");
                 Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                 browserIntent.setData(Uri.parse(url_to_website));
                 startActivity(browserIntent);
             }

    });
}