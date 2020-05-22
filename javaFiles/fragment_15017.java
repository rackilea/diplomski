public class MyRememberMeProcessingFilter extends RememberMeProcessingFilter { 
    private myService; 

    @Override 
    protected void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult) { 
        // perform some custom logic when the user has been 'remembered' & authenticated - e.g. update a login count etc 
        this.myService.doSomeCustomBusinessLogic(authResult.getName()); 

        super.onSuccessfulAuthentication(request, response, authResult); 
    } 
}