@Override 
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    String strtext = getArguments().getString("edttext");    //Get the data using getArguments()
    return inflater.inflate(R.layout.fragment, container, false);
}