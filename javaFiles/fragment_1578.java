import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.HandList;
import com.leapmotion.leap.processing.LeapMotion;
import com.leapmotion.leap.SwipeGesture;
import com.leapmotion.leap.Vector;

LeapMotion leapMotion;

void setup()
{
  size(16 * 50, 9 * 50);
  background(20);

  leapMotion = new LeapMotion(this);
}

void draw()
{
  fill(20);
  rect(0, 0, width, height);
}

void onInit(final Controller controller)
{
  controller.enableGesture(Gesture.Type.TYPE_SWIPE);
  // enable top mounted policy
  //controller.setPolicyFlags(Controller.PolicyFlag.POLICY_OPTIMIZE_HMD);
}

void onFrame(final Controller controller)
{
  Frame frame = controller.frame();
  for (Gesture gesture : frame.gestures())
  {

 if(gesture.type() == Gesture.Type.TYPE_SWIPE) {
    SwipeGesture swipeGesture = new SwipeGesture(gesture);

    Vector swipeVector  = swipeGesture.direction();
    println("swipeVector : " + swipeVector);

    float swipeDirection = swipeVector.getX();
    println(swipeDirection);
   }
}

  HandList hands = frame.hands();
  //println(hands.count());
}