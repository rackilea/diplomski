public void handle(Callback[] callbacks)throws IOException, UnsupportedCallbackException 
 {
     for (int i = 0; i < callbacks.length; i++) 
     {
         if 
         {
             . . . .
         }
         else if (callbacks[i] instanceof NameCallback) 
         {

    // prompt the user for a username
    NameCallback nc = (NameCallback)callbacks[i];  
    System.err.print(nc.getPrompt());
    System.err.flush();
    nc.setName(Video_Game_Store.usrName.getText());

     } 
         else if (callbacks[i] instanceof PasswordCallback) 
         {

    // prompt the user for sensitive information
    PasswordCallback pc = (PasswordCallback)callbacks[i];
    System.err.print(pc.getPrompt());
    System.err.flush();         
            pc.setPassword(Video_Game_Store.psWord.getText().toCharArray());

     } 
         else 
         {
    throw new UnsupportedCallbackException
        (callbacks[i], "Unrecognized Callback");
     }
 }
 }