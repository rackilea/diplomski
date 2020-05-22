public boolean operate(String test) {          
   if (!count.stream().anyMatch(e -> e.strVar.equals(test))) {      
      count.add(new MyExternalClass(test));      
      return true;
   }
   return false;
}