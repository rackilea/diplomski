private Button button;
private LinearLayout layoutListView;
private LinearLayout.LayoutParams lpListView;


@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_container);

    button = (Button) findViewById(R.id.button);

    layoutListView = (LinearLayout) findViewById(R.id.listTreeView);

    lpListView = new LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT);

    lpListView.weight = 20;



    button.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

            if (lpListView.weight == 0) {



                lpListView.weight = 20;




            } else {

                lpListView.weight = 0;


            }

            layoutListView.setLayoutParams(lpListView);




        }
    });



}