@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_camera);

    mainModel = (MainModel)getIntent().getSerializableExtra("serialized_data");

    createVideoFolder();

    mChronometer = (Chronometer) findViewById(R.id.chronometer);
    mTextureView = (TextureView) findViewById(R.id.textureView);
    mRecordButton = (Button) findViewById(R.id.videoButton);

    mRecordButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mIsRecording || mIsTimelapse) {
                mChronometer.stop();
                mChronometer.setVisibility(View.INVISIBLE);
                mIsRecording = false;
                mIsTimelapse = false;

                // Starting the preview prior to stopping recording which should hopefully
                // resolve issues being seen in Samsung devices.
                startPreview();
                mMediaRecorder.stop();
                mMediaRecorder.reset();

                Intent mediaStoreUpdateIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                mediaStoreUpdateIntent.setData(Uri.fromFile(new File(mVideoFileName)));
                sendBroadcast(mediaStoreUpdateIntent);

                goNext();

            } else {
                mIsRecording = true;
                checkWriteStoragePermission();
            }
        }
    });
    mIsRecording = true;

}