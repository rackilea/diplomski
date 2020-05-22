float mass = body.getMass();
float targetVelocity = 16.6667f; //For 60kmph simulated
Vector2 targetPosition = new Vector2(touchpoint.x, touchpoint.y);

// Now calculate the impulse magnitude and use it to scale
// a direction (because its 2D movement)
float impulseMag = mass * targetVelocity;

// Point the cannon towards the touch point
Vector2 impulse = new Vector2();

// Point the impulse from the cannon ball to the target
impulse.set(targetPosition).sub(body.getPosition());

// Normalize the direction (to get a constant speed)
impulse.nor();

// Scale by the calculated magnitude
impulse.scl(impulseMag);

// Apply the impulse to the centre so there is no rotation and wake
// the body if it is sleeping
body.applyLinearImpulse(impulse, body.getWorldCentre(), true);