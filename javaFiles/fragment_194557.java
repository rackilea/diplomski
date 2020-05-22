protected void onCreate(Bundle savedInstanceState) {
        ...
        HorizontalScrollView sv = findViewById(R.id.scroll);
        sv.post(new Runnable() {
            @Override
            public void run() {
                sv.smoothScrollBy(100, 0);
            }
        })
    }