@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.custom_listview_main);
Intent msjIntent = getIntent();
tblName = msjIntent.getStringExtra(WordDefinitionHomeActivity.TABLENAME2);
refresh();
}