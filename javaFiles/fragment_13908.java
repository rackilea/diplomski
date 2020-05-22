if(email.equals(sa[0]) && opass.equals(sa[1]))         
      { 
     //if new password and retype password is same do below      
     if(npass.equals(rpass)){

             //write your update code   
           BufferedWriter bw = null;
        try 
        {
         bw = new BufferedWriter(new FileWriter(Constants.USERFILE));
         bw.write(rpass);
        bw.newLine();
        }
        catch (IOException e)
        {
        e.printStackTrace();
        } 
        finally 
        {
        if (bw != null)
            bw.close();
        }
       }
      }   
      else
      {
        //if new password and retype password is not same 
           if(!npass.equals(rpass)){
                    //setting some message
                   request.setAttribute("passerrormsg2", "Password Mismatch");
                  //redirect to changePassword.Html

            } 
               //if old pass is not equal 
            if( !opass.equals(sa[1])){  
                   //set some message
                   request.setAttribute("passerrormsg1", "Old Password is not correct");
                  //redirect to changePassword.html         
            } 

      }