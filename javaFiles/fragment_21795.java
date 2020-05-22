package test.example;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class AminationDemo extends Activity implements OnClickListener {

    ImageView img;

    Button strtbtn,stpbtn;

    AnimationDrawable mAnimation;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        img = (ImageView) findViewById(R.id.iv);

        BitmapDrawable frame0 = (BitmapDrawable)getResources().getDrawable(R.drawable.f0);
        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.f1);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.f2);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.f3);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.f4);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.f5);

        int reasonableDuration = 750;
        mAnimation = new AnimationDrawable();
        mAnimation.addFrame(frame0, reasonableDuration);
        mAnimation.addFrame(frame1, reasonableDuration);
        mAnimation.addFrame(frame2, reasonableDuration);
        mAnimation.addFrame(frame3, reasonableDuration);
        mAnimation.addFrame(frame4, reasonableDuration);
        mAnimation.addFrame(frame5, reasonableDuration);

        img.setBackgroundDrawable(mAnimation);        
        strtbtn = (Button) findViewById(R.id.strtbtn);
        strtbtn.setOnClickListener(this);
        stpbtn = (Button) findViewById(R.id.stpbtn);
        stpbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

      if(v.getId()== R.id.strtbtn){

          mAnimation.start();
          mAnimation.setOneShot(false);
      }
      else
        mAnimation.stop();
    }  
}