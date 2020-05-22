boolean foundTreasure = false;

while(file.hasNext()){
     if(file.next().equals(treasure)){
          foundTreasure = true;
          break; // found treasure, if you need to use it, assign to variable beforehand
     }
}
    // out here, either we never found treasure at all, or the last element we looked as was treasure... act accordingly