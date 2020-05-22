public class Black extends Activity {
     ImageView imageView;
     MediaPlayer mp;

     int sound=525,sound1=525;


     public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);

         setContentView(R.layout.black);
       Button Button1 = (Button) findViewById(R.id.button1);
       imageView= (ImageView)findViewById(R.id.image1);
       Button1.setOnClickListner( new OnClickListener(){
           public void onClick(view v){
            onClickImageView(v);
           }
       });
     }

    public void onClickImageView(View view) {

        int[] picture= {
         R.drawable.black,R.drawable.blackairplane,R.drawable.blackbear,R.drawable.blackcar,R.drawable.blackcircle,R.drawable.blackkite,R.drawable.blacksquare,R.drawable.blacktriangle};
         Random r = new Random();
         int n=r.nextInt(7);
         imageView.setImageResource(picture[n]);

         switch (picture[n]) { //here is the change in code
          case R.drawable.black: 
               sound = R.raw.sayblack;
               break;

          case R.drawable.blackairplane: 
               sound = R.raw.sayblack ;
               sound1= R.raw.sayplane;
               break;

          case R.drawable.blackcar: 
                   sound = R.raw.sayblack;
                   sound1= R.raw.saycar;
                   break;

          case R.drawable.blackcircle: 
               sound = R.raw.sayblack ;
               sound1=R.raw.saycircle;
               break;

          case R.drawable.blackkite: 
               sound = R.raw.sayblack ;
               sound1 = + R.raw.saykite;
               break;

          case R.drawable.blacksquare: 
               sound = R.raw.sayblack ;
               sound1 =  R.raw.saysquare;
               break;

          case R.drawable.blacktriangle: 
               sound = R.raw.sayblack ;
               sound1= R.raw.saytriangle;
               break;
         }

         if(mp!=null){
          mp.release();
         }
         if(sound!=0){
         mp = MediaPlayer.create(getBaseContext(), sound);
           mp.start();

         }


          mp.setOnCompletionListener (new MediaPlayer.OnCompletionListener(){

          @Override
           public void onCompletion(MediaPlayer arg0) {
           // TODO Auto-generated method stub
            if(sound1!=0 && sound!=0){
            mp= MediaPlayer.create(getBaseContext(),sound1);
            mp.start();
            sound=sound1=525;
            }}
          });

         }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}