// These are the variables you need.
int x = 200, y0 = 0, y = 0, velocity = 15;
double t = 0.0, gravity = -9.8;

// This is the statement that should run when you update the GUI.
// It is the fundamental equation for motion with constant acceleration.
// The acceleration is the gravitational constant.
y = (int) (y0 + velocity * t + .5 * gravity * t * t);
if (y < 0) {
    y = y0 = 0; 
    //Stop jumping!
    Jump = false; 
} else {
    // Swap the y values.
    y0 = y;
    // Increase the time with the frame rate.
    t += frameRate;
}
// Draw the character using the y value