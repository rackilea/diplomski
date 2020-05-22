class MyActivity extends Activity {

RadioButton _Rone, _Rtwo, _Rthree;

@Override
protected void onCreate(Bundle savedInstanceState) {

//after setContentView(.....)

    _Rone = (RadioButton) findViewById(R.id.radio_one);
    _Rtwo = (RadioButton) findViewById(R.id.radio_two);
    _Rthree = (RadioButton) findViewById(R.id.radio_three);

    _Rone.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
            _Rone.setChecked(true);
            _Rtwo.setChecked(false);
            _Rthree.setChecked(false);
        }
    });

    _Rtwo.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
            _Rone.setChecked(false);
            _Rtwo.setChecked(true);
            _Rthree.setChecked(false);
        }
    });

    _Rthree.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
            _Rone.setChecked(false);
            _Rtwo.setChecked(false);
            _Rthree.setChecked(true);
        }
    });
 // do code here
}`