HttpServletRequest request = (HttpServletRequest) messageInfo.getRequestMessage();
Principal userPrincipal = request.getUserPrincipal();

if (userPrincipal != null) {   
    handler.handle(new Callback[] { 
        new CallerPrincipalCallback(clientSubject, userPrincipal) }
    );

    return SUCCESS;   
}