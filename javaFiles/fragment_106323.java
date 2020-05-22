@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
View view=inflater.inflate(R.layout.advfrag_layout, container, false);
    inSnow = (EditText) view.getView().findViewById(R.id.inchesSnow);
    durnStorm = (EditText)view.getView().findViewById(R.id.durationStorm);
    pSnow = (EditText)view. getView().findViewById(R.id.peakRate);
    pTime = (EditText)view.getView().findViewById(R.id.peakRateTime);
    fSnow = (EditText)view. getView().findViewById(R.id.finalRate);
    wSpeed = (EditText)view. getView().findViewById(R.id.windSpeed);
    sGround = (EditText) view.getView().findViewById(R.id.snowGround);
    results = (TextView)view. getView().findViewById(R.id.resultView);
    calc = (Button)view. getView().findViewById(R.id.button);

    return view;




}