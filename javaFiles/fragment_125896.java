StringBuilder jsCall = new StringBuilder();
jsCall.append("var request = new XMLHttpRequest();");
jsCall.append("request.open(\"GET\", \"");
jsCall.append(AdminUI.getS42Url());

//set credentials to user: _ and pw: _
jsCall.append("\", true, \"_\", \"_\");");
jsCall.append("request.send();");

//execute JS call
JavaScript.getCurrent().execute(jsCall.toString());

//logout user and destroy session
VaadinRequest vaadinRequest = VaadinService.getCurrentRequest();
VaadinServletRequest vaadinServletRequest = (VaadinServletRequest) vaadinRequest;
HttpServletRequest hsRequest = vaadinServletRequest.getHttpServletRequest();
try
{
    hsRequest.logout();
}
catch (ServletException e)
{
    LOG.error("", e);
}