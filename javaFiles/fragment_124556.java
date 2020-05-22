class MyResponse {

   int status; 
   public Map<String, APIMethod> result;    
}

class APIMethod {

    String description;
    String function;
    // etc
}