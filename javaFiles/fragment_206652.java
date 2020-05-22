public Object[] toArray3() {  
   Object[] toArray = new Object[numOfElements]; //first cast no longer necessary
   int i=0;  
   for (Object data : this) {  //pretend MyStack is no longer generic
      toArray[i++] = data;  
   }  
   return toArray;  
}