//Change speed to your need
final float speed=0.1f,ispeed=1.0f-speed;
//The result is roughly: old_position*0.9 + target * 0.1
cameraPosition.scale(ispeed);
target.scale(speed);
cameraPosition.add(target);

camera.position.set(cameraPosition);