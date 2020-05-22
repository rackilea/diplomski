public class Board_Play1 extends Activity {

int d=0,a=0,b=0,turn=2;
Random random = new Random();

@Override
protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_play1);
        EditText diceno = (EditText) findViewById(R.id.editText1);
        EditText p1 = (EditText) findViewById(R.id.editText2);
        EditText p2 = (EditText) findViewById(R.id.editText3);

        diceno.setText(String.valueOf(d));  
        p1.setText(String.valueOf(a));
        p2.setText(String.valueOf(b));
        EditText diceno = (EditText) findViewById(R.id.editText1);
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        // This is user Turn
                        d=random.nextInt(6)+1;
                        diceno.setText(String.valueOf(d));
                        calculateDiceno();

                        //This is Application Trun. You may add some delay with progress bar

                        d=random.nextInt(6)+1;
                        diceno.setText(String.valueOf(d));
                        calculateDiceno();


                    }

        }); 


 }

    private void calculateDiceno(){
           if(turn%2==0)
                a+=d;
            else
                b+=d;

        if(a>100)
            a-=d;
        if(b>100)
            b-=d;


            p1.setText(String.valueOf(a));
            p2.setText(String.valueOf(b));
            turn++;
        }


}