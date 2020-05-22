@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_fragment, container, false);
        getDialog().setTitle("Enter message");
     Button clearButton = (Button) rootView.findViewById(R.id.button_clear);

       clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageText.setText(null);
            }
        });
        return rootView;
    }