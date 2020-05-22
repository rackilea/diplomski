private static final String ARG_PARAM1 = "param1";

public static FeedFragment newInstance(int param1) {
    FeedFragment fragment = new FeedFragment();
    Bundle args = new Bundle();
    args.putInt(ARG_PARAM1, param1);
    fragment.setArguments(args);
    return fragment;
}