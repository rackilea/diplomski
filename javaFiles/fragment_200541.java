static Enemies Slime = null;
static Enemies Rat = null;
static Enemies Goblin = null;

// This evaluation of the variables (e.g. Slime) happens RIGHT NOW.
static Enemies[] Enemies = {Slime, Rat, Goblin};

// Such that it is equivalent to the following
// (Which cause an NPE on Enemies.monsters[i].Name in the loop)
static Enemies[] Enemies = {null, null, null};