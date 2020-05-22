public class MainActivity extends Activity implements View.OnClickListener {

    private ArrayList<RelativeLayout> buttons = new ArrayList<RelativeLayout>();
    private ArrayList<Integer> drawableId = new ArrayList<Integer>();
    private LinearLayout linear;
    private ScrollView scrool;
    private int index;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        linear = (LinearLayout) findViewById(R.id.Rlayout);
        scrool = (ScrollView) findViewById(R.id.scrool);


        for (int i = 0; i < linear.getChildCount(); i++) {
            {
                String buttonID = "Llayout" + i;
                int resID = getResources().getIdentifier(buttonID, "id",getPackageName());
                buttons.add((RelativeLayout)findViewById(resID));
                buttons.get(i).setOnClickListener(this);
                drawableId.add(getResources().getIdentifier("supa" + i, "drawable", getPackageName()));
            }
        }
    }


    @Override
    public void onClick(View v) {
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getId() == v.getId()) {
                index = i;
                Toast.makeText(MyActivity.this,String.valueOf(index),Toast.LENGTH_SHORT).show();
                Intent trimite = new Intent(MainActivity.this, RecipeView.class);
                Bundle colet = new Bundle();
                colet.putString("key", Content.RETETE[i]);
                colet.putInt("keyimg", drawableId.get(i));
                trimite.putExtras(colet);
                startActivity(trimite);
                break;
            }
        }
    }
}