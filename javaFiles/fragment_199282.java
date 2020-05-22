public void rendertext() throws IOException {
    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();
    Map<String, String> params = ec.getRequestParameterMap();
    String foo = params.get("foo"); // Returns request parameter with name "foo".
    // ...

    ec.setResponseContentType("text/plain");
    ec.setResponseCharacterEncoding("UTF-8");
    ec.getResponseOutputWriter().write("Some text content");
    // ...

    fc.responseComplete(); // Important! Prevents JSF from proceeding to render HTML.
}