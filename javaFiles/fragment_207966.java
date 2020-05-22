package app.test;

import android.app.Activity;
import android.os.Bundle;

import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class Test extends Activity implements
RadioGroup.OnCheckedChangeListener {
  RadioGroup orientation;
  RadioGroup gravity;

  @Override
  public void onCreate(Bundle icicle) {
super.onCreate(icicle);
setContentView(R.layout.main);

orientation = (RadioGroup) findViewById(R.id.orientation);
orientation.setOnCheckedChangeListener(this);
gravity = (RadioGroup) findViewById(R.id.gravity);
gravity.setOnCheckedChangeListener(this);
  }

  public void onCheckedChanged(RadioGroup group, int checkedId) {
switch (checkedId) {
case R.id.horizontal:
  orientation.setOrientation(LinearLayout.HORIZONTAL);
  break;

case R.id.vertical:
  orientation.setOrientation(LinearLayout.VERTICAL);
  break;

case R.id.left:
  gravity.setGravity(Gravity.LEFT);
  break;

case R.id.center:
  gravity.setGravity(Gravity.CENTER_HORIZONTAL);
  break;

case R.id.right:
  gravity.setGravity(Gravity.RIGHT);
  break;
}
  }
}

//main.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
  xmlns:android="http://schemas.android.com/apk/res/android"
  android:orientation="vertical"
  android:layout_width="fill_parent"
  android:layout_height="fill_parent"
  >
  <RadioGroup android:id="@+id/orientation"
android:orientation="horizontal"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:padding="5px">
<RadioButton
  android:id="@+id/horizontal"
  android:text="horizontal" />
<RadioButton
  android:id="@+id/vertical"
  android:text="vertical" />
  </RadioGroup>
  <RadioGroup android:id="@+id/gravity"
    android:orientation="vertical"
    android:layout_width="fill_parent"
    android:layout_height="wrap_content"
    android:padding="5px">
    <RadioButton
      android:id="@+id/left"
      android:text="left" />
    <RadioButton
      android:id="@+id/center"
      android:text="center" />
    <RadioButton
      android:id="@+id/right"
      android:text="right" />
  </RadioGroup>
   </LinearLayout>