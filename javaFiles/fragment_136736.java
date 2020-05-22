@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
        mParam1 = getArguments().getString(ARG_PARAM1);
        mParam2 = getArguments().getString(ARG_PARAM2);
    }
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.fragment_all_questions, container, false);

    ListView mListView = (ListView) rootView.findViewById(R.id.list_view);

    mContext = getActivity().getApplicationContext();
    mDBHelper = new DataBaseHelper(mContext);
    mDBHelper.createDataBase();

    try {
        mDBHelper.openDataBase();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    mCursor = mDBHelper.getCursor();
    getActivity().startManagingCursor(mCursor);

    adapter = new QuestionAdapter(mCursor);
    mListView.setAdapter(adapter);

    return rootView;
}