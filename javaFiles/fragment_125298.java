public class MainActivity extends AppCompatActivity {

int flag;
public void change(View view) {

ImageView img1 = (ImageView) findViewById(R.id.single);
ImageView img2 = (ImageView) findViewById(R.id.withands);
switch(flag){

  case 0:
            img1.animate().alpha(0f).setDuration(2000);
            img2.animate().alpha(1f).setDuration(2000);
            flag=1;
            break;
    case 1:   
        img1.animate().alpha(1f).setDuration(2000);
        img2.animate().alpha(0f).setDuration(2000);
        flag=0;
        break;
  }
}
 @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_main);
   flag = 0;
   ImageView img1=(ImageView) findViewById(R.id.single);
   ImageView img2=(ImageView) findViewById(R.id.withands);
   img1.animate().alpha(1f).setDuration(2000);
   img2.animate().alpha(0f).setDuration(2);

 }

 }