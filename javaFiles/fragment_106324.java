@Override
public void onActivityCreated(Bundle savedInstanceState) {
// TODO Auto-generated method stub
super.onActivityCreated(savedInstanceState);
nSnow = (EditText) getView().findViewById(R.id.inchesSnow);
    durnStorm = (EditText)getView().findViewById(R.id.durationStorm);
    pSnow = (EditText) getView().findViewById(R.id.peakRate);
    pTime = (EditText)getView().findViewById(R.id.peakRateTime);
    fSnow = (EditText) getView().findViewById(R.id.finalRate);
    wSpeed = (EditText) getView().findViewById(R.id.windSpeed);
    sGround = (EditText) getView().findViewById(R.id.snowGround);
    results = (TextView) getView().findViewById(R.id.resultView);
    calc = (Button) getView().findViewById(R.id.button);