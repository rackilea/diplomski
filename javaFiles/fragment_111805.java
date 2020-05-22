import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.processing.LeapMotion;

LeapMotion leapMotion;

float zoomFactor = 0;

void setup()
{
size(16 * 50, 9 * 50);
background(20);
frameRate(30);

leapMotion = new LeapMotion(this);
}

void draw()
{
fill(20);
rect(0, 0, width, height);
fill(200);
rect(0, 0, (zoomFactor * 100), (zoomFactor * 100));
}


 void onFrame(final Controller controller)
{
Frame frame = controller.frame();
Frame sinceFrame = controller.frame(25);
zoomFactor = frame.scaleFactor(sinceFrame);
println(zoomFactor);
}