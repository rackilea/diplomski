public static DynamicFragment newInstance(String val) {
    DynamicFragment fragment = new DynamicFragment();
    Bundle args = new Bundle();
    args.putString("someValue", val);
    fragment.setArguments(args);
    return fragment;
}