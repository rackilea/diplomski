public void logIn() {
    RequestContext context = RequestContext.getCurrentInstance();          
    boolean loggedIn = false;
    if(authentificationEJB.saveUserState(email, password)) {
        notificationValue = "Dobro dosli";
         loggedIn = true;             
         context.addCallbackParam("loggedIn", loggedIn);
    }   
}