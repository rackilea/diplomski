@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.song_detail);

    ...

    int BigCoverArt = intent.getIntExtra("coverArt", 0);

    ...
}