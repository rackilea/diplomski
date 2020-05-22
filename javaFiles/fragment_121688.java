int[] ids = new int[]{R.id.ivTextView, R.id.degreeTextView, R.id.initialYTextView, R.id.initialXTextView, R.id.timeTextView, R.id.distanceTextView, R.id.peakTextView};
TextView ivTextView, degreeTextView,initialYTextView, initialXTextView, timeTextView, distanceTextView, peakTextView;
TextView[] texts={ivTextView, degreeTextView,initialYTextView, initialXTextView, timeTextView};
@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.results);
    //Reference the TextViews
    for(int i =0; i < names.length; i++ ){
        texts[i] = (TextView) findViewById(ids[i]);
    }