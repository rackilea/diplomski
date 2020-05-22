@Override
public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    spnLinee = (Spinner) getView().findViewById(R.id.spinnerLinee);
    adapter =new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item);
    spnLinee.setAdapter(adapter);
    ...