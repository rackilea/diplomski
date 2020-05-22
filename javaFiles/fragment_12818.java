public class bootActivity extends Activity {

    Context ctx;
    private CheckBox checkboxLocation;
    private CheckBox checkboxAudioRecording;
    private CheckBox checkboxStorage;
    private Activity thisActivity;
    private String[] permissionsArray=new String[]{Manifest.permission.RECORD_AUDIO,
                                                    Manifest.permission.ACCESS_FINE_LOCATION,
                                                    Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.READ_EXTERNAL_STORAGE,
                                                    Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.WRITE_EXTERNAL_STORAGE,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app.loge("BOOTING....START");

        setContentView(R.layout.activity_boot);
        thisActivity=this;

        app.setBootingTRUE(getApplicationContext());
        ctx=getApplicationContext();

        //BIND UI
        checkboxLocation=(CheckBox)findViewById(R.id.checkboxlocation);
        checkboxLocation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b==true) {
                    if (needPermissionLocation()) {
                        app.loge("Requesting LOCATION permission");
                        ActivityCompat.requestPermissions(thisActivity, permissionsArray,appPermissionsCallbackConstant);
                    }
                }
                refreshUI();
                if((!needPermissionLocation())&&(!needPermissionRecordAudio())&&(!(needPermissionStorage()))){
                    launchApp();
                }
            }
        });
        checkboxAudioRecording=(CheckBox)findViewById(R.id.checkboxaudiorecording);
        checkboxAudioRecording.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b==true) {
                    if (needPermissionRecordAudio()) {
                        app.loge("Requesting RECORDING permission");
                        ActivityCompat.requestPermissions(thisActivity, permissionsArray, appPermissionsCallbackConstant);
                    }
                }
                refreshUI();
                if((!needPermissionLocation())&&(!needPermissionRecordAudio())&&(!(needPermissionStorage()))){
                    launchApp();
                }
            }
        });
        checkboxStorage=(CheckBox)findViewById(R.id.checkboxstorage);
        checkboxStorage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b==true) {
                    if (needPermissionStorage()) {
                        app.loge("Requesting STORAGE permissions");
                        ActivityCompat.requestPermissions(thisActivity, permissionsArray, appPermissionsCallbackConstant);
                    }
                }
                refreshUI();
                if((!needPermissionLocation())&&(!needPermissionRecordAudio())&&(!(needPermissionStorage()))){
                    launchApp();
                }
            }
        });

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();
        if(data!=null) {
            app.logy("URI:" + data.toString());
            String userinput=data.getQueryParameter("input");
            app.logy("User Input: "+userinput);
            if(userinput!=null) {
                //app.setBootingFALSE(getApplicationContext());
                app.setDeeplinkInput(ctx,userinput);
                app.logy("USER INPUT: " + userinput);
            }
        }


        if(action!=null) {
            app.logy("ACTION:" + action);
        }
        //  checkPermissions(); //launches app if permissions are OK, if not, updates permission status on the checkboxes
        app.logy("BOOTING....END");
    }//end onCreate

    boolean needPermissionLocation(){
        return ((ContextCompat.checkSelfPermission(thisActivity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)||
                (ContextCompat.checkSelfPermission(thisActivity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED));
    }
    boolean needPermissionRecordAudio(){
        return (ContextCompat.checkSelfPermission(thisActivity, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED);
    }
    boolean needPermissionStorage(){
        return ((ContextCompat.checkSelfPermission(thisActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)&&
                (ContextCompat.checkSelfPermission(thisActivity, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==appPermissionsCallbackConstant){
            app.loge("BootActivity.onRequestPermissionsResult");
            refreshUI();

            if((!needPermissionLocation())&&(!needPermissionRecordAudio())&&(!needPermissionStorage())){
                launchApp();
            }
        }
    }

    void refreshUI(){
        app.loge("refreshUI()");
        //Refresh CHECKBOXES with permissions
        if(needPermissionRecordAudio())
            checkboxAudioRecording.setChecked(false);
        else
            checkboxAudioRecording.setChecked(true);

        if(needPermissionLocation())
            checkboxLocation.setChecked(false);
        else
            checkboxLocation.setChecked(true);

        if(needPermissionStorage())
            checkboxStorage.setChecked(false);
        else
            checkboxStorage.setChecked(true);
    }

    void launchApp(){
        app.loge("BootActivity.LaunchApp()");
        Intent i = new Intent(bootActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }
    final int appPermissionsCallbackConstant=1111;
    void checkPermissions(){
        app.loge("BootActivity.checkPermissions()");
        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED)&&
                (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)&&
                (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)&&
                (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)&&
                (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)){
            app.loge("All permissions are OK");
            checkboxAudioRecording.setChecked(true);
            checkboxLocation.setChecked(true);
            checkboxStorage.setChecked(true);
            launchApp();
        }

            // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            checkboxAudioRecording.setChecked(false);
            app.loge("Requesting RECORD_AUDIO PERMISSION");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO},appPermissionsCallbackConstant);
        }
        else{
            checkboxAudioRecording.setChecked(true);
        }

        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)||
                (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            app.loge("Requesting LOCATION PERMISSIONS");
            checkboxLocation.setChecked(false);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},appPermissionsCallbackConstant);
        }
        else{
            checkboxLocation.setChecked(true);
        }

        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)||
                (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)){
            checkboxStorage.setChecked(false);
            app.loge("Requesting STORAGE READ/WRITE PERMISSION");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},appPermissionsCallbackConstant);
        }
        else{
            checkboxStorage.setChecked(true);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        app.loge("BootActivity.onResume");
        thisActivity=this;
        refreshUI();
        if((!needPermissionLocation())&&(!needPermissionRecordAudio())&&(!needPermissionStorage())){
            launchApp();
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        this.setIntent(intent);
    }
}