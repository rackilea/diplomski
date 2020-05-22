private Button button;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    button = findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isStoragePermissionGranted()) {
                String rout = copyFiletoExternalStorage(R.raw.guitar,"guitar.mp3");
                Uri uri = Uri.parse(rout);
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("audio/*");
                share.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                share.putExtra(Intent.EXTRA_STREAM,uri);
                try {
                    startActivity(share);
                }catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(getApplicationContext(),"Please, install Whatsapp", Toast.LENGTH_LONG).show();
                }
            }
        }
    });