@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View rootView;

    if(running) {

        rootView = inflater.inflate(R.layout.LayoutforLoginActivity, container, false);
    }else {
        rootView = inflater.inflate(R.layout.LayoutforNonLoginActivity, container, false);

    }