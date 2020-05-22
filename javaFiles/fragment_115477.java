PrintWriter out = response.getWriter();
Enumeration<String> parameterNames = request.getParameterNames();
while (parameterNames.hasMoreElements()) {
    String param = (String) parameterNames.nextElement();
    out.println(param + " = [" + request.getParameter(param) + "]");
}