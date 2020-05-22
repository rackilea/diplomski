movement = new Vector2D();

if (moveLeft) movement.x += 1;
if (moveRight) movement.x -= 1;
if (moveUp) movement.y -= 1;
if (moveDown) movement.y += 1;

movement.normalize();   // Caps the movement vector at a length of one, even when it's at an odd angle
movement *= desiredMovementSpeed * frameDeltaTime;  // Plug in suitable values here
// FIXME: Do some collision detection here, probably
playerX += movement.x;
playerY += movement.y;