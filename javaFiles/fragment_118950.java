public class MainActivity extends AppCompatActivity {

    Boolean rotating = false;
    Integer durationOfSpin = 3000; //default 3000

    ImageView image;

    ObjectAnimator animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStart = (Button) findViewById(R.id.button);
        Button buttonStop = (Button) findViewById(R.id.buttonStop);
        image = (ImageView) findViewById(R.id.imageView_roulette);


        buttonStart.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if(!rotating) {
                    rotating = true;
                    animation = ObjectAnimator.ofFloat(
                            image, "rotation", 0, 360);

                    animation.setDuration(durationOfSpin);
                    animation.setInterpolator(new LinearInterpolator());
                    animation.setRepeatCount(Animation.INFINITE);
                    animation.start();

                }else{
                    if(durationOfSpin - 300 > 0) {
                        durationOfSpin -= 300;   //make slightly faster each subsequent click
                    }
                    animation.setDuration(durationOfSpin);

                }
            }
        });

        buttonStop.setOnClickListener(new Button.OnClickListener() {
            //just here so you can cancel your rotation
            public void onClick(View v) {
                if(rotating) {
                    rotating = false;
                    durationOfSpin = 3000;      //set back to default
                    animation.cancel();
                }
            }
        });

    }
}