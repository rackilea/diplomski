public class MyActivity extends Activity implements OnPreDrawListener{
  int height;

  method(){
    ..
    view.addOnPreDrawListener(this);
    ..
  }

  @Override
  public boolean onPreDraw(){
    height = itemLayout.getMeasuredHeight();
  }  
}