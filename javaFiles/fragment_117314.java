@Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCloud = new Cloud(); //New instance will be created
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.dream_purpose_edit,container,false);
        purposeEText = (EditText)v.findViewById(R.id.purpose_edit);


        purposeEText.setText(mCloud.getPurposeText()); // 'mCloud' is a new object everytime and hence will not have your saved value

        return v;
    }