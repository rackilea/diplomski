public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView imageView= (ImageView) findViewById(R.id.imageView);

        final Context context=this;
        final String[] sss = {""};
        final Handler hh = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Picasso.with(context).load(sss[0]).resize(500, 281).centerCrop().into(imageView);
            }
        };
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                sss[0] = "http://teleflora.edgesuite.net/images/products/HW0_706075.jpg";
                hh.sendEmptyMessage(0);

            }
        });
        th.start();
    }
}