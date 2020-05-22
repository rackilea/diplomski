public int score;
public int highScore;
SharedPreferences data;
public static String filename = "HighScore"; // This is shared preference name


@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);