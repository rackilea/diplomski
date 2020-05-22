for(Class cl : classes){ 
    int sumNodes = 0;
    for(Method m : cl.getMethod){
       sumNodes += getNodeCount(m);
   }
  System.out.print("sumNodes="+sumNodes)
}