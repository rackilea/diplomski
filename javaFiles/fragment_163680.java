try{
       actualmassage = Integer.parseInt(error);
        }catch (NumberFormatException e) {
          error="0";
        }//catch1
      }//if1
         if((error1.length() != 0)){
           try{ 
            actualnotification=Integer.parseInt(error1);
             }catch(NumberFormatException ee){
              error1="0";
               }//catch2
           }//if2   
        if((error2.length() != 0)){ 
              try{
                   actualfriend=Integer.parseInt(error2);
                 }catch(NumberFormatException eee){
                   error2="0";
                 }//catch3
                }//if3