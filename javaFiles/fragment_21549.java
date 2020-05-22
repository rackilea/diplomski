public String user1;
public String user2;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
user1 = getIntent().getExtras().getString("a_value");
user2 = getIntent().getExtras().getString("b_value");
          ...........
                    ...........