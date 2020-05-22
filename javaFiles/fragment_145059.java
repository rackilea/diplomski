public class Game extends Activity implements OnClickListener{

    Button start_time;
    Button buttongame1;
    int i;


       Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);
          start_time = (Button) findViewById(R.id.start_time);
          start_time.setOnClickListener(this);
          textview1 = (TextView) findViewById(R.id.over);
          gameover = (Button) findViewById(R.id.gameover);
          gameover.setOnClickListener(this);

          i = 0;
          r = new Random();
       buttongame1 = (Button) findViewById(R.id.buttongame1);
       btn_start2 = (Button) findViewById(R.id.btn_start2);


         smthin();  


    }


    public void smthin() {


         DisplayMetrics displaymetrics = new DisplayMetrics();
          getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
          int height = displaymetrics.heightPixels;
          int Width = displaymetrics.widthPixels;


                    try { 

                        if (i == 0) {
                      buttongame1.setX(r.nextInt(Width - buttongame1.getHeight()));
                        buttongame1.setY(r.nextInt(height - buttongame1.getWidth()));

                        }


                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

    }