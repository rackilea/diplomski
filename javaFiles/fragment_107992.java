public String intercept(ActionInvocation invocation) throws Exception {

    // Get the action configuration defined in struts.xml
    ActionConfig config = invocation.getProxy().getConfig(); 

    // Get the SUCCESS result configured for that Action
    ResultConfig success = config.getResults().get("success");

    // Get the class of the SUCCESS result
    Object clazz = success.getClass(); 

    /* .... oops, some error occurred !! 
       We now need to redirect to the right global error result .... */

    if (clazz instanceof org.apache.struts2.dispatcher.ServletDispatcherResult) {
        log.debug("Struts2 Result type: CLASSIC");
        return "error";
    } else if (clazz instanceof org.apache.struts2.json.JSONResult) {
        log.debug("Struts2 Result type: JSON");
        return "jsonError";
    } else {
        log.debug("Struts2 Result type: SOMETHING ELSE, returning default ");
        return "error";
    }
}