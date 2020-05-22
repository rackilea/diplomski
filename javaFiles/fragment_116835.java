public class MainActivity extends Activity 
{

    Button spin;
    Button reel1,reel2,reel3,reel4;
    private String rnd,rnd2,rnd3,rnd4;

    int count1=50;

    @Override
   protected void onCreate(Bundle savedInstanceState)
    {super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        addListenerOnButton();}

    public void perform_action(View v){}

    public void addListenerOnButton() {


        spin = (Button) findViewById(R.id.spin);
        spin.setOnClickListener(new OnClickListener() {

                @Override
            public void onClick(View v) {



                String rndm[]  = {"A","B","C","D"};
                {rnd = rndm[(int) (Math.random() *     rndm.length)];}
                String rndm2[]  = {"A","B","C","D"};
                {rnd2 = rndm2[(int) (Math.random() *     rndm2.length)];}
                String rndm3[]  = {"A","B","C","D"};
                {rnd3 = rndm3[(int) (Math.random() *     rndm3.length)];}
                String rndm4[]  = {"A","B","C","D"};
                {rnd4 = rndm4[(int) (Math.random() *     rndm4.length)];}


                    {Toast.makeText(getApplicationContext(),"button pressed",     Toast.LENGTH_SHORT).show();}


                {Button tv = (Button)     findViewById(R.id.reel1);
                    tv.setText(String.valueOf(rnd));
                    tv.setTextColor(Color.parseColor("#000000"));}

                {Button tv = (Button)     findViewById(R.id.reel2);
                    tv.setText(String.valueOf(rnd2));
                    tv.setTextColor(Color.parseColor("#000000"));}

                {Button tv = (Button)     findViewById(R.id.reel3);
                    tv.setText(String.valueOf(rnd3));
                    tv.setTextColor(Color.parseColor("#000000"));}

                {Button tv = (Button)     findViewById(R.id.reel4);
                    tv.setText(String.valueOf(rnd4));
                    tv.setTextColor(Color.parseColor("#000000"));