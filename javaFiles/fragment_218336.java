// Declared as fields, so they will be reused
Vector2 position = new Vector2();
Vector2 velocity = new Vector2();
Vector2 movement = new Vector2();

Vector2 touch = new Vector2();
Vector2 dir = new Vector2();

// On touch events, set the touch vector, then do this to get the direction vector
dir.set(touch).sub(position).nor();