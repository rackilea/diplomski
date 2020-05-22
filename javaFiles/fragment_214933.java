@Override
public void onViewCreated (View view, Bundle savedInstanceState) {

    ActionBar actionBar = getActivity().getActionBar();
    actionBar.hide();
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
    TextView testtext = (TextView) getActivity().findViewById(R.id.testtext);
    String parola = prefs.getString("prefUserPassword","defaultpass");
    testtext.setText(" "+parola);
    if (getArguments() != null) {
        mParam1 = getArguments().getString(ARG_PARAM1);
        mParam2 = getArguments().getString(ARG_PARAM2);
    }

}