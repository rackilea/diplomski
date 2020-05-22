@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_main, container, false);

    final Spinner spinner = (Spinner) rootView.findViewById(R.id.email_spinner);

    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
            R.array.email_array, android.R.layout.simple_spinner_item);

    // Specify the layout to use when the list of choices appears
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    // Apply the adapter to the spinner
    spinner.setAdapter(adapter);

    Button buttonSubmit = (Button) rootView.findViewById(R.id.NextActivity);
    buttonSubmit.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent i = new Intent(getActivity().getApplicationContext(), Second.class);
            i.putExtra("SpinnerValue", spinner.getSelectedItem().toString());
            getActivity().startActivity(i);

        }
    });
    return rootView;
}