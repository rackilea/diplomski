List<String> values = new ArrayList();
Enumeration<String> enumeration = req.getParameterNames();
while (enumeration.hasMoreElements()) {
    String parameterName = (String) enumeration.nextElement();
    if(parameterName.startsWith("rd_")) {
        values.add(req.getParameter(parameterName));
    }
}