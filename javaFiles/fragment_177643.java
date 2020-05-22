public void handle(Callback[] callbacks)
 throws IOException, UnsupportedCallbackException {

   for (int i = 0; i < callbacks.length; i++) {
      if (callbacks[i] instanceof PasswordCallback) {

          // prompt the user for sensitive information
          PasswordCallback pc = (PasswordCallback)callbacks[i];
          System.err.print(pc.getPrompt());
          System.err.flush();
          pc.setPassword(readPassword(System.in));

      } 
   }
 }