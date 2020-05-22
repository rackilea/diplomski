@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState, persistentState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);
    fillView();
}