public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.microsoft_fragment, container, false);

    ImageButton imageButton = view.findViewById(R.id. wordbtn);
    imageButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //from here call clickMSWORD or implement logic
            clickMSWORD(v);
        }
    });

    return view;
}