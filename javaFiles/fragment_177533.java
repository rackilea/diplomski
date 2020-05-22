@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_main, container,
            false);
    TextView t = (TextView) rootView.findViewById(R.id.textView1);
    t.setText("hi world.");
    return rootView;
}