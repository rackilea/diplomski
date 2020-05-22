for (String s : toTest) 
        {
            try
             {
                 InternetAddress emailAddr = new InternetAddress(s);                    
                 emailAddr.validate();
                 System.out.println(s + " is a valid E-Mail Address.");                        
             }    
            catch (AddressException ex)
             {
             System.out.println(s + " is not a valid E-Mail Address.");
              }

       }