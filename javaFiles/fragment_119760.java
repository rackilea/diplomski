public class MultipleButton extends Activity {

    String night;
    Button mBtn1, mBtn2, mBtn3, mBtn4, mBtn5;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mBtn1=(Button)findViewById(R.id.button1);
        mBtn1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                night="button1";
                Intent intent = new Intent();
                intent.setClass(MultipleButton.this, My_videos.class);
                intent.putExtra("video", night);
                startActivity(intent);
            }
        });

        mBtn2=(Button)findViewById(R.id.button2);
        mBtn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                night="button2";
                Intent intent = new Intent();
                intent.setClass(MultipleButton.this, My_videos.class);
                intent.putExtra("video", night);
                startActivity(intent);
            }
        });

        mBtn3=(Button)findViewById(R.id.button3);
        mBtn3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                night="button3";
                Intent intent = new Intent();
                intent.setClass(MultipleButton.this, My_videos.class);
                intent.putExtra("video", night);
                startActivity(intent);
            }
        });

        mBtn4=(Button)findViewById(R.id.button4);
        mBtn4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                night="button4";
                Intent intent = new Intent();
                intent.setClass(MultipleButton.this, My_videos.class);
                intent.putExtra("video", night);
                startActivity(intent);
            }
        });

        mBtn5=(Button)findViewById(R.id.button5);
        mBtn5.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                night="button5";
                Intent intent = new Intent();
                intent.setClass(MultipleButton.this, My_videos.class);
                intent.putExtra("video", night);
                startActivity(intent);
            }
        });
    }
}