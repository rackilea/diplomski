int x = ...;
int y = ...;
calculate here x and y values of the clicked block by using a formular ( don't use this slow overlay-stuff, when you're in a gridworld);
boolean blockAlreadyExists = false;
for(Block block: yourBlockArray) {
   blockAlreadyExists = block.check(x, y);
   if(blockAlreadyExists) {
      break; // you don't need to check the remaining blocks, aslong you know that the block with the given x and y values already exists
   }
}
if(!blockAlreadyExists) {
   yourBlockArray.add(new Block(x, y); // add the new block, when it's not already there
}