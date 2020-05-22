@Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_flashlight);
    flashlightButton = (ImageButton) findViewById(R.id.flashOnOffButton);
    flashlightOnOrOff = false; 
} // REMOVE THIS 

//Error if device does not have flashlight 
    boolean hasFlash = this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    if(hasFlash==false)
    {
        AlertDialog dialo = new AlertDialog.Builder(Flashlight.this).create();
        dialo.setTitle("Error");
        dialo.setMessage("Sorry your device does not have flashlight");
        dialo.setButton(BUTTON_POSITIVE, "OK", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        dialo.show();
    }
} // THIS IS WHERE YOUR ONCREATE CLOSING BRACE GOES