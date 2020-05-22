@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

bFlash = (Button)findViewById(R.id.btnFlash);
cFlash = (Button)findViewById(R.id.closeFlash);
//initialize bnmcamera
bnmcamera = new MyCamera();

bFlash.setOnClickListener(new OnClickListener() {

    public void onClick(View arg0) {
        // TODO Auto-generated method stub

        bnmcamera.getCamera();
        bnmcamera.turnOnFlash();

    }
});


cFlash.setOnClickListener(new OnClickListener() {

    public void onClick(View arg0) {
        // TODO Auto-generated method stub

        bnmcamera.turnOffFlash();

    }
});

}