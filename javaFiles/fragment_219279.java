public T pop (){
   if (isEmpty()){
       throw new RuntimeException("Stack is empty");
   }
   else{
       T ret = top.data;
       top = top.next;
       return ret;
   }
}