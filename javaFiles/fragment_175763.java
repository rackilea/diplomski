private static final int REQUEST_CODE = 111;
private ImageView scannedImageView;
Button scan;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scan);
    scannedImageView = findViewById(R.id.scanned_image); // this  ImageView should be in your activity_scan.xml file with same id(scanned_image)
    startScan();

    scan = findViewById(R.id.open_scan);
    scan.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           startScan();
        }
    });
}

private void startScan() {
    Intent intent = new Intent(ScanActivity2.this, ScanActivity.class);
    startActivityForResult(intent, REQUEST_CODE);
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == REQUEST_CODE) {
        if(resultCode == Activity.RESULT_OK) {
            if(null != data && null != data.getExtras()) {
                String filePath = data.getExtras().getString(ScanConstants.SCANNED_RESULT);
                Bitmap baseBitmap = ScanUtils.decodeBitmapFromFile(filePath, ScanConstants.IMAGE_NAME);
                scannedImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                scannedImageView.setImageBitmap(baseBitmap);
            }
        } else if(resultCode == Activity.RESULT_CANCELED) {
            finish();
        }
    }
}