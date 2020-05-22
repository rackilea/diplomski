List<String> requestParameterNames = Collections.list((Enumeration<String>) request.getParameterNames());

for (String parameterName : requestParameterNames) {
    String attributeName = parameterName;
    String attributeValue = request.getParameter(parameterName);

    //DO YOUR STUFF
}
//DO YOUR STUFF