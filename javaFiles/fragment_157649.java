@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState)
{
    View view = inflater.inflate(R.layout.scan_fragment, container, false);

    Button menuButton = (Button)view.findViewById(R.id.btnMenu);
    menuButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Log.e("app", "onclick listener");
        }
    });

    return view;
}