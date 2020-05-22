@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewResivedSMSDetailes customListView = new ViewResivedSMSDetailes(getActivity(),testArray1,testArray2);
        setListAdapter( customListView ); //call the method if listFragment

    }