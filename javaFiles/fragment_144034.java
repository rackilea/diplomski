public void run()  
    {
         String line;
         try    
         {
            while(true)   
            {
                        line = input.readLine();
                if("EXIT".equals(line))
                {
                    output.println("Closing Connection  . . . Goodbye");
                    clients.remove(this);
                    users.remove(name);
                    break;
                }
                else if(name.equals(line))
                {
                    output.println("OK");
                }
                else
                {
                    // Seems to me just adding this else part will do the trick for point one.
                    boradcast(name,line); // method  of outer class - send messages to all
                }
            }// end of while
         } // try
         catch(Exception e) 
         {
           System.out.println(e.getMessage());
         }
    }