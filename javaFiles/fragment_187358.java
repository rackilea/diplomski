// Here we create a room that can contain only dog cages
Room<Cage<Dog>> room = new Room<Cage<Dog>>(); 

// But the method needs a "any kind of animal cage" room
// Therefore we get error during compilation
add3(room);