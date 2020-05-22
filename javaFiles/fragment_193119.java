package com.example.ads;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.gms.ads.*;

public class MainActivity extends Activity {

private static final int BANNER_AD_WIDTH = 320;    

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

// Look up the AdView as a resource and load a request.
AdView adView = (AdView)this.findViewById(R.id.adView);
AdRequest adRequest = new AdRequest.Builder().build();
adView.loadAd(adRequest);

int placementWidth = BANNER_AD_WIDTH;
adView.setWidth(placementWidth);
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
getMenuInflater().inflate(R.menu.main, menu);
return true;
}

}