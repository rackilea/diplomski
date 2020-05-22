class ExtraParam extends WebAuthenticationDetails {

private static final long serialVersionUID = 1L;
private final String company;

public ExtraParam(HttpServletRequest request) {
    super(request);
    this.company = request.getParameter("company");
}

public String getCompanyName() {
    return company;
}   
}