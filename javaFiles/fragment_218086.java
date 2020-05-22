public class Main2Activity extends AppCompatActivity {

    public TextView t1,t2;
    public int ta,tb;
    public int w1,w2;
    public int balls = 10,w =1,t =1;
    LinearLayout l1,l2;
    RelativeLayout r1;
    ViewGroup vg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        t1=findViewById(R.id.TeamA);
        ta=0;
        t2=findViewById(R.id.TeamB);
        ta=0;

        w1=0;
        w2=0;
        l1=(LinearLayout)findViewById(R.id.a);
        l2=(LinearLayout)findViewById(R.id.b);
        vg1=(ViewGroup)l2.getParent();
        r1=(RelativeLayout)findViewById(R.id.bowling);
        TeamABatting();


    }

    public void a1(View view){
        score_add(1,t1);

    }
    public void a2(View view){
        score_add(2,t1);

    }
    public void a3(View view){
        score_add(3,t1);

    }
    public void a4(View view){
        score_add(4,t1);

    }
    public void a6(View view){
        score_add(6,t1);

    }
    public void b1(View view){
        score_add(1,t2);

    }
    public void b2(View view){
        score_add(2,t2);

    }
    public void b3(View view){
        score_add(3,t2);

    }
    public void b4(View view){
        score_add(4,t2);

    }
    public void b6(View view){
        score_add(6,t2);

    }
    public  void score_add(int a ,TextView t3){
        if(t3==findViewById(R.id.TeamA)){
            ta+=a;
            Score_doner(t3,ta,w1);
        }
        if(t3==findViewById(R.id.TeamB)){
            tb+=a;
            Score_doner(t3,tb,w2);
        }


    }
    public void TeamAOut(View view){
        w1++;
        Score_doner(t1,ta,w1);
    }
    public void TeamBOut(View view){
        w2++;
        Score_doner(t2,tb,w2);
    }
    public void Score_doner(TextView t4,int runs,int wicket){
        t4.setText(Integer.toString(runs)+"/"+Integer.toString(wicket));

    }
    public void TeamABatting(){
        l2.removeAllViews();
        View v1=getLayoutInflater().inflate(R.layout.demo,null);
        l2.addView(v1);




    }
    public void TeamBBatting(){
        l1.removeAllViews();
        View v1=getLayoutInflater().inflate(R.layout.demo,null);
        l1.addView(v1);

    }
}