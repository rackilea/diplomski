public class HttpServletRequestWithDataOfInterest extends HttpServletRequestWrapper {

    private DataOfInterest data;

    public HttpServletRequestWithDataOfInterest(HttpServletRequest request, DataOfInterest data) {
        super(request);
        this.data = data;
    }

    public String getParameter(String name) {
        return data.getParameter(name);
    }

    public String[] getParameterValues(String name) {
        return data.getParameterValues(name);
    }

    // Etc, only when necessary.
}