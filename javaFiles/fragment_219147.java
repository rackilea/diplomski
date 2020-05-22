@Override
public void onCreate(Bundle savedInstanceState) {
    // more codes...
    Handler mHandler = new Handler();
    mBtnStop = (Button) findViewById(R.id.btn_stop);
    mBtnStop.setBackgroundResource(R.drawable.stop_upload);
    mBtnStop.setOnClickListener(mHandlerStop);
    mBtnStop.setVisibility(View.INVISIBLE);

    View.OnClickListener mHandlerStop = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            stopUpload(); // called when "stop upload" button is clicked
        }
    };

    // more codes...
}