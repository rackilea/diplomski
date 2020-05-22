@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    listView = (ListView) findViewById(R.id.list_view);
    bossView = (TextView) findViewById(R.id.boss_time);
    boss_title = getResources().getStringArray(R.array.boss_array);
    adapter = new BossAdapter(getApplicationContext(), R.layout.boss_layout);
    listView.setAdapter(adapter);

    bossTime = getTime();
    int i = 0;
    // Moved our object creation here, so that it should only be done once.
    for (String boss : boss_title) {
        Boss bossObject = new Boss(boss_icon[i], boss, bossTime[i]);
        adapter.add(bossObject);
        i++;
    }

    handler = new Handler();
    Runnable update = new Runnable() {
        @Override
        public void run() {
            bossTime = getTime();
            int count = adapter.getCount()
            for (int i = 0; i < count; i++) {
                ((Boss) adapter.getItem(i)).setBoss_time(bossTime[i]); // Re-set time
            }
            adapter.notifyDataSetChanged(); // Notify our update
            handler.postDelayed(this , 1000);
        }
    };
    handler.postDelayed(update, 10);
}