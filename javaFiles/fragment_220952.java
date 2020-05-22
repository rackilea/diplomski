public String getHeader(String name) {
    if ("accept".equals(name)) {
         return null; //or any valid value
    }
    String header = super.getHeader(name);
    return (header != null) ? header : super.getParameter(name); 
}