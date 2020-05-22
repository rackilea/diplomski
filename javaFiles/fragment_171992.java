boolean notNull = false;
for(String[] array : user){
    for(String val : array){
      if(val!=null){
        notNull=true;
        break;
      }
    }
}
if(notNull){
  System.out.println("Array not empty)";
}else{
     System.out.println("Array empty");
}