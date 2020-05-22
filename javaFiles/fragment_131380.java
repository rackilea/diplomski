@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_main, container, false);

    toggleButton = (Button) v.findViewById(R.id.buttonToggleChronometer);
    resetButton = (Button) v.findViewById(R.id.buttonReset);
    chronometer = (Chronometer) v.findViewById(R.id.mainChronometer);

    toggleButton.setOnClickListener(this);
    resetButton.setOnClickListener(this);

    if (savedInstanceState != null) {
        chronometer.setBase(savedInstanceState.getLong("time"));
        if (savedInstanceState.getBoolean("isTiming")) {
            chronometer.start();
            currentlyTiming = savedInstanceState.getBoolean("isTiming");
        }
    }

    return v;
}