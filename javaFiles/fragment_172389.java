for(Class cl : classes){
    for(Method m : cl.getMethod){
       numNodes = getNodeCount(m);
   }
 System.out.print(sum(numNodes));//this doesnt work.
}