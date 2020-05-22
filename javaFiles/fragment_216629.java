//class var
float lastJumpForceTime = 0.5f; // start at 0.5f to enable jumping from the start
float jumpForceDelay = 0.5f;  // delay between jumps, 0.5f = half second


//method that calls your code
//delta time is the time since last update LibGDX provides this but you will need to pass it
public void yourMethod(float deltaTime, ...){
  lastJumpForceTime += deltaTime;  // update last jump time
  // check if player is on ground and if time since last jump is > delay
  if(cl.isPlayerOnGround() && lastJumpForceTime >= jumpForceDelay){
      lastJumpForceTime = 0.0f;
      playerBody.applyForceToCenter(0, B2DVars.jumpForce, true);
  }
}