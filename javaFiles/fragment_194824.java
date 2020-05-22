Enumeration parameters = request.getParameterNames();
  while(parameters.hasMoreElements()) {
    String parameterName = parameters.nextElement().toString();
    if(parameterName.startsWith("updateattendance")){
       String parameterValue = request.getParameter(parameterName);
       // parameterValue is value of radio button parameter
    }
  }