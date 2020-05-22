public static String toJSON(Object object) 
    { 
        if ( object == null ){
        return "{}"; 
        } 
        try { 
           ObjectMapper mapper = new ObjectMapper(); 
           return mapper.writeValueAsString(object); 
           } 
        catch (Exception e) { 
         e.printStackTrace(); 
        } 
      return "{}"; 
      }