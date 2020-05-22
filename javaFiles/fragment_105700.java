public String unaffectedReference(){
    String message = "Important msg";
    try{
        return message;
    }finally{
        message = " meaning of life";
    }
   }