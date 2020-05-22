public int howMany(int value){
  // i prefer checks at the beginnin with a return
  if(value < 0) return -1; 
  if(value > 6) return -1; 

  int total = 0;
  // loop over all rolled values (alternative form to classic for loop)
  for(int rolledVal : rolledValues){
     // check if rolled value equals given value
     if(rolledVal == value){
        // count it
        total++;
     }
  }

return total;
}