TextView storyText;
...
@Override
public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game_start);
    storyText = (TextView) findViewById(R.id.storyText);
}