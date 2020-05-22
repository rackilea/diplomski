static Enemies createSlime (){
   Enemies slime = new Enemies();
   // ..
   return slime;
}

// i.e.
static Enemies Slime = createSlime();
static Enemies[] Enemies = {Slime, ..};
// or even
static Enemies[] Enemies = {createSlime(), ..};