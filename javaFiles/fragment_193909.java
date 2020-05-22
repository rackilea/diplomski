public class new_app extends AppCompatActivity {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_app);

        // You need to initialize it here. 
        progressDialog = new ProgressDialog(this);

        Button down2 = (Button) findViewById(R.id.down);
        down2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                progressDialog.show();
                Intent intent = new Intent(Emoji11ios.this, DownloadService.class);
                intent.putExtra("url", "https://dl.dropboxusercontent.com/s/14rzjsl26zf0mqf/SCR%20Screen%20Recorder%20Pro%20V0.21.7.apk");
                intent.putExtra("receiver", new DownloadReceiver(new Handler()));
                startService(intent);

                    }
        });
    }
}