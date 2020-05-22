for(int i=0;i<recDataSize;i++){
      int test = recData.getKey();
      stacks[i] = new LinkedList<Integer>();
      while(test > 0) {
           stacks[i].push(test % 10);
           test = test/10;             
     } 
     while(stacks[i].size() < 5) stacks[i].addFirst(0);
     //Add 0 in the input now not in printing function
 }