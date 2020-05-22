package com.unicorn.test.whee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class SplashScreenPear extends Activity {

ImageView pearfade;
/** Called when the activity is first created. */

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.pear);
    ImageView pearfade = (ImageView) findViewById(R.id.pearish);
}

private void startAnimating(){

 Animation pearfadeact = AnimationUtils.loadAnimation(this, R.anim.fadein);
 pearfadeact.setAnimationListener(new AnimationListener() {

   public void onAnimationEnd(Animation animation) {
             // The animation has ended, transition to the Main Menu screen
             startActivity(new Intent(SplashScreenPear.this, Unicorn.class));
             SplashScreenPear.this.finish();
         }

         public void onAnimationRepeat(Animation animation) {
         }

         public void onAnimationStart(Animation animation) {
         }
     });
     pearfade.startAnimation(pearfadeact);

}

 @Override
 protected void onPause() {
  super.onPause();
  pearfade.clearAnimation(); 
 }
 @Override
 protected void onResume() {
     super.onResume();
     startAnimating();
 }