// Assuming move is called for each time frame
// We can update the location of ship using modulo when it exceeds the bounds
public void move(Dimension bounds) {
   // TODO Move the ship its speed. The ship should wrap around
   // within its box. (Hint: move the ship by the size of the
   // bounding area to wrap it around; you may need to do this
   // more than once if the ship is moving fast enough.)

   location = speed.move(location);

   if (location.getX() > bounds.width) {
      location.setLocation(location.getX() % bounds.width), location.getY());
   }
   else if (location.getX() < 0) {
      location.setLocation(bounds.width - location.getX(), location.getY());
   }

   if (location.getY() > bounds.height) {
      location.setLocation(location.getX(), location.getY() % bounds.height);
   }
   else if (location.getY() < 0) {
      location.setLocation(location.getX(), bounds.height - location.getY());
   }
}