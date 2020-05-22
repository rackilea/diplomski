public class VideoActivity extends Activity {
ImageView blipImg;
@Override
protected void onCreate(Bundle savedInstanceState) 
{
   super.onCreate(savedInstanceState);
   setContentView(R.layout.yourlayout);
   blipImg = (ImageView)findViewById(R.id.videoBlip);
   blipImg.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://blip.tv"));
        startActivity(intent);
        }
   });
 }
}