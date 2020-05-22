public Optional<?>  getResponse(String input) {
   if(input.equals("A")) {       
       return objA.getResponse();  // This returns an optional of POJO A1 or Optional.empty()
   } else {
       return objB.getResponse();  // This returns an optional of POJO B1 or Optional.empty()
   }
}