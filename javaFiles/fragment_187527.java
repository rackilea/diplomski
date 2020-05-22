String sPathInfo = request.getPathInfo();
if ("/ValidateValues".equals(sPathInfo)) {
    // TODO: Check if NAME and AGE are contained in the ParameterMap!
    String sName = request.getParameterMap().get("NAME")[0];
    String sAge = request.getParameterMap().get("AGE")[0];
    Notification.show(String.format("Name: %s Age: %s", sName, sAge));
}
else {
    // not correct path
}