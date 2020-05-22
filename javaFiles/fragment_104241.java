@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.sidefragment, container, true);
    final Spinner s = (Spinner) v.findViewById(
            R.id.track_spinner);
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this
            .getActivity().getBaseContext(),
            android.R.layout.simple_spinner_item, tracks);
    s.setAdapter(adapter);

    s.setOnItemSelectedListener(new OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1,
                int arg2, long arg3) {
            int item = s.getSelectedItemPosition();
            Toast.makeText(SideFragment.this.getActivity().getBaseContext(),
                    "clicked "+item, Toast.LENGTH_SHORT).show();
        }

            @Override
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    });
    return v;
}