for(int i=0;i<recDataSize;i++){
          int test = recDada.getKey();
          stacks[i] = new LinkedList<Integer>();
         while(test > 0) {
               stacks[i].push(test % 10);
               test = test/10;             
         } 
}