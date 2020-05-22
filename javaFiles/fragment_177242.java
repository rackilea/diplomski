@Inject
private Request request;

public String getId() {
    return this.request.getParameter("id");
}