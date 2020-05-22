@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Switch switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // true if the switch is in the On position
                if(isChecked){
                    editText.setFocusableInTouchMode(true);
                    editText.setFocusable(true);
                }else{
                    editText.setFocusableInTouchMode(false);
                    editText.setFocusable(false);
                }
            }
        });

    }