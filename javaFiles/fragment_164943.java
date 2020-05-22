@RequestMapping(value="/run", method=RequestMethod.POST)    
    public String runScript(@RequestParam Integer order) {     
    String message = null;
        try{
            //some code here//
    } catch (Exception e) { 
      message = e.getMessage();
        log.error("An unexpected error occurred when attempting to run script. The error was: " + e.getMessage() + ".", e);
    }
        return message != null ? message : "something that you want to return";

    }