public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    View fragView = inflater.inflate(R.layout.activity_main, container, false);
    TextView text = (TextView) fragView.findViewById(R.id.text);
    text.setText(mText);
    return fragView;
}