public static InfoFragment newInstance(Tool tool)  {
    InfoFragment fragment = new InfoFragment();
    Bundle args = new Bundle();
    args.putParcelable("arg_tool", tool);
    fragment.setArguments(args);
    return fragment;
}

private Tool mTool;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle args = getArguments();
    mTool = args.getParcelable("arg_tool");
}

@Override
public void onViewCreated(View view,Bundle savedInstanceState) {
    // obtain view references
    if (mTool != null) {
        updateDisplay();
    }
}