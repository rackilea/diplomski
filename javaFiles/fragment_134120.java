private int mParam1;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
        mParam1 = getArguments().getInt(ARG_PARAM1);
    }
} 

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
{
    Log.i(TAG, "Entered FeedFragment.java onCreateView()");
    View v = inflater.inflate(R.layout.fragment_feed, container,false);;
    text = v.findViewById(R.id.feed_view);
    text.setText(String.valueOf(mParam1));
    return v;
}