import ketai.ui.*;
import android.view.MotionEvent;

float ellipseWidth = 50;
float ellipseHeight = 50;
KetaiGesture gesture;

void setup() {
  size(displayWidth, displayHeight);
  gesture = new KetaiGesture(this);
}

void draw() {
  orientation(PORTRAIT);
  background(0);
  fill(0);
  stroke(255);
  ellipse(width/2, height/2, ellipseWidth, ellipseHeight);
}

void onPinch (float x, float y, float d) {
  ellipseWidth += d;
  ellipseHeight += d;
}

public boolean surfaceTouchEvent(MotionEvent event) {
  //Call this to keep mouseX and mouseY updated
  super.surfaceTouchEvent(event);

  //Forward the event to the class for processing
  return gesture.surfaceTouchEvent(event);
}