paint(Graphics g) {       
   // calls paint() on all objects in the game world
}

// you should call this once per frame
update(World w) {
   // call update() on each game-world object
}

// in Tank
fire(Tank t, Point target) {
   // creates a bullet at the tanks' position, and adds it to the World
}

// within Bullet
update() {
   // moves this bullet along its path to its target; 
   // if target reached, add an explosion there and destroy the bullet
}

// within Explosion
update() {
   // advance to next explosion frame; 
   // or if finished, destroy the explosion object
}