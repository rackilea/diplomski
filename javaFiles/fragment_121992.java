int x = ...;
int y = ...;
calculate your x and y values the same way as above;
Block blockToDelete;
for(Block block: yourBlockArray) {
   if(block.check(x, y)) {
      blockToDelete = block;
      break; // you don't need to check the remaining blocks, aslong you deleted the clicked block and there cannot exist another one with the same x and y values.
   }
}
if(blockToDelete != null) {
   yourBlockArray.remove(blockToDelete, true);
}