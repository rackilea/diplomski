// define animation for 0.4 turn object
final RotateAnimation rotateObj3_part1 = new RotateAnimation(0, 360*0.4f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f); // 360*0.4 = 144 deg
rotateObj3_part1.setDuration((long) (5000*0.4)); // 5 sec for full circle, 2 sec for 0.4 of circle
rotateObj3_part1.setFillAfter(true); // this will make object stay in rotated position
rotateObj3_part1.setRepeatCount(0);

ImageView object3 = (ImageView)findViewById(R.id.object3);
object3.startAnimation(rotateObj3_part1);