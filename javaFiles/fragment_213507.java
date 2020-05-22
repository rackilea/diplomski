@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

    final View rootView=inflater.inflate(R.layout.fragment_blank, container, false);

    //using findViewById() in a Fragment
    Button button=rootView.findViewById(R.id.button_id);

    //handle onclick events for the button
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            EditText time = rootView.findViewById(R.id.editTime);

        }
    });

    return rootView;
}