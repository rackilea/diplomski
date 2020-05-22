/* Main Method */
// You get a new Player object using direct user input
// (Which is somewhat dangerous, you should do some data validation first)
Player player = new Player(scan.nextLine())

/* Player constructor */
// Let's say user entered correctly "Barbarian". You are in the process of constructing
// a new Player object when you call this:
classes.Barbar();

/* Barbar method */
// The very first line creates a brand new player - different from one you were
// in the process of constructing. 
Player player = new Player(); 
// Then you assign values to the new Player, which goes out of scope as soon as the
// method ends.