try {
       ....

       SecurityContextHolder.getContext().setAuthentication(authResult);


 } catch (AuthenticationException failed) {
        SecurityContextHolder.clearContext();
 }