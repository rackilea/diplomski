public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
        // It is after a return statement! 
        View v = inflater.inflate(R.layout.creator ,container,false);
        //You are creating a variable which is not being used
        return v;
    }