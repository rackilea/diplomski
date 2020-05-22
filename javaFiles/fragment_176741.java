public class MainActivity extends ActionBarActivity {

    TextView score;
    public int newscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = (TextView) findViewById(R.id.textView1);    


       Random rand = new Random();
    int image = rand.nextInt(4);
    int newImage = getImageResourceId(image);

    if(newImage == R.drawable.a){ 
         newscore = newscore+1;
         score.setText(newscore);
    }

    if(newImage == R.drawable.b){ 
         newscore = newscore+10;
         score.setText(newscore);
     }

     if(newImage == R.drawable.c){
          newscore = newscore+100;
          score.setText(newscore);
     }

     if(newImage == R.drawable.d){ 
           newscore = newscore+1000;
           score.setText(newscore);
     }
}

public int getImageResourceId(int image) { 

switch (image) {
     case 0:
         return R.drawable.a;
     case 1: 
         return R.drawable.b;
     case 2:
         return R.drawable.c;
     case 3: 
         return R.drawable.d;
     default:
         return R.drawable.a;
    }
}

}