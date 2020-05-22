@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


 // position is zero based tab.
 int position = 0;

Intent intent = getIntent();

    String intentaction = intent.getAction();

    if (intentaction != null) {
        if (intentaction.equals("hello world")) {
             position = 2;
        }
    }


actionbar.setSelectedNavigationItem(position);