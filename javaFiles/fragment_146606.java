@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
    recordId = getArguments().getInt(BundleHelper.RECORD_ID);
}