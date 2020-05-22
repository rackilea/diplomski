@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.place_holder_fragment, container, false);
    servicesTxtView= (TextView) view.findViewById(R.id.services_text);
    servicesTxtView.setText("ANYTHING");
    return view;
}