@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    memoList = findViewById(R.id.memoList);
    addMemo = findViewById(R.id.addMemo);

    //Initialize the memos with empty array list before using it.
    memos = new ArrayList<>();
    memoAdapter = new MemoAdapter(this, memos);

    // Set LayoutManager and Adapter to RecyclerView
    memoList.setLayoutManager(new LinearLayoutManager(this));
    memoList.setAdapter(memoAdapter);
}