@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Get the view from fragmenttab1.xml
    View v = inflater.inflate(R.layout.fragmenttab1, container, false);
    v.findViewById(R.id.button1).setOnClickListener(this);
    return v;
}