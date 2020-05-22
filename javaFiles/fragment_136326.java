@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    args = this.getArguments();
    tabTitles = args.getStringArrayList("tabTitles");
    view = inflater.inflate(R.layout.descriptive_tables_tabs, null);
    tabsLayout = (TableLayout) view.findViewById(R.id.myTabsRow);

    toLoadTabs = (FrameLayout) view.findViewById(R.id.toLoadTable);
    tabButtons = new ArrayList<Button>();
    //ArrayList<DescriptiveTablesFragment> tables = (DescriptiveTablesFragment) args.getParcelableArrayList("tables");

    Log.i(LOG_TAG, "Tabs Title Size: " + tabTitles.size());
    float weight = 1f;
    Log.i(LOG_TAG, "WEIGHT: " + weight);

    TableRow myRow = new TableRow(getActivity());
    myRow.setWeightSum((float) tabTitles.size());
    TableRow.LayoutParams params = new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT, weight);
    for (String s : tabTitles) {
        Button mButton = (Button) inflater.inflate(R.layout.tab_button, null);
        View separator = inflater.inflate(R.layout.separator, null);
        mButton.setText(s);
        mButton.setLayoutParams(params);
        tabButtons.add(mButton);
        myRow.addView(mButton);
        myRow.addView(separator);
    }
    tabsLayout.addView(myRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));
    return view;
}