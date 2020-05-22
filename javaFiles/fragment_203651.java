public class MainActivity extends Activity {
    Button b;
    Drawable back;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button) findViewById(R.id.button1);

        back=b.getBackground();

        b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {   
                if(flag==0){
                    b.setBackgroundResource(R.drawable.btn_default_pressed_holo_dark);
                    flag=1;
                    }
                else{
                    flag=0;
                    b.setBackground(back);
                }
            }
        });
    }


}