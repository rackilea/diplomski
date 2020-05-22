ArrayList<String> businessNames = new ArrayList<String>();
List<Spanned> businessInfo = new ArrayList<Spanned>();
ArrayList<String> businessCategories = new ArrayList<String>();


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    expListView = (ExpandableListView) findViewById(R.id.lvExp);
    String userChoice = (String) getIntent().getExtras().get("userChoice");

        if (savedInstanceState != null){
            businessInfo = (List<Spanned>) savedInstanceState.getSerializable("businessInfo");
            businessNames = savedInstanceState.getStringArrayList("businessNames");
            businessCategories = savedInstanceState.getStringArrayList("businessCategories");

            new DisplaySavedResults().execute();

        } else {
            new RetreiveSearchResults().execute(userChoice);
        }
}


protected void onSaveInstanceState(Bundle savedInstanceState) {
    super.onSaveInstanceState(savedInstanceState);
    savedInstanceState.putStringArrayList("businessNames", businessNames);
    savedInstanceState.putStringArrayList("businessCategories", businessCategories);
    savedInstanceState.putSerializable("businessInfo", (Serializable) businessInfo);
}