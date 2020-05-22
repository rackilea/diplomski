//Add 0s to each stack
for (int i = 0; i <stacks.length; i++) {
     while(stacks[i].size() < 5) stacks[i].addFirst(0);
}

//Assuming all stacks are length 5 as they have been set in loop i
for (int j = 0; j < 5; j++) {
   for (int i = 0; i <stacks.length; i++) {
           System.out.print(stacks[i].get(j)+" ");
    }
   System.out.println();
}