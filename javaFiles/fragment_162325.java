@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.your_layout);

    View myView = findViewById(R.id.myView);
    int[] attrs = new int[]{R.attr.selectableItemBackground};
    TypedArray typedArray = getActivity().obtainStyledAttributes(attrs);
    int backgroundResource = typedArray.getResourceId(0, 0);
    myView.setBackgroundResource(backgroundResource);
}