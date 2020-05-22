public class MyFragment extends Fragment {
    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.my_fragment, container,
                false);
        return rootView;

    }

//and you use rootView to call findViewById
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button myButton = (Button) rootView.findViewById(R.id.mybutton);
        //or you can set some other listener, or "catch" some different view -checkbox,          //textview etc
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something you want
            }
        });
    }