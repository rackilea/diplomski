public class MyActivity extends AppCompatActivity {


    RecyclerView myRecyclerView;
    TabLayout myTabLayout;
    LinearLayoutManager linearLayoutManager;
    ArrayList<String> arrayList = new ArrayList<>();
    DataAdapter adapter;
    private boolean isUserScrolling = false;
    private boolean isListGoingUp = true;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        myTabLayout = findViewById(R.id.myTabLayout);



        myRecyclerView = findViewById(R.id.myRecyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(linearLayoutManager);
        myRecyclerView.setHasFixedSize(true);

        for (int i = 0; i < 120; i++) {
            arrayList.add("Item " + i);
        }

        adapter= new DataAdapter(this,arrayList);
        myRecyclerView.setAdapter(adapter);

        myTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                isUserScrolling = false ;
                int position = tab.getPosition();
                if(position==0){
                    myRecyclerView.smoothScrollToPosition(0);
                }else if(position==1){
                    myRecyclerView.smoothScrollToPosition(30);
                }else if(position==2){
                    myRecyclerView.smoothScrollToPosition(60);
                }else if(position==3){
                    myRecyclerView.smoothScrollToPosition(90);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        myRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                    isUserScrolling = true;
                    if (isListGoingUp) {
                        //my recycler view is actually inverted so I have to write this condition instead
                        if (linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1 == arrayList.size()) {
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    if (isListGoingUp) {
                                        if (linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1 == arrayList.size()) {
                                            Toast.makeText(MyActivity.this, "exeute something", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            }, 50);
                            //waiting for 50ms because when scrolling down from top, the variable isListGoingUp is still true until the onScrolled method is executed
                        }
                    }
                }

            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int itemPosition = linearLayoutManager.findFirstVisibleItemPosition();


                if(isUserScrolling){
                    if (itemPosition == 0) { //  item position of uses
                        TabLayout.Tab tab = myTabLayout.getTabAt(0);
                        tab.select();
                    } else if (itemPosition == 30) {//  item position of side effects
                        TabLayout.Tab tab = myTabLayout.getTabAt(1);
                        tab.select();
                    } else if (itemPosition == 60) {//  item position of how it works
                        TabLayout.Tab tab = myTabLayout.getTabAt(2);
                        tab.select();
                    } else if (itemPosition == 90) {//  item position of precaution
                        TabLayout.Tab tab = myTabLayout.getTabAt(3);
                        tab.select();
                    }
                }



            }
        });


    }


}