private String requestedURI;

@PostConstruct
public void init() {
    requestedURI = FacesContext.getCurrentInstance().getExternalContext()
        .getRequestMap().get(RequestDispatcher.FORWARD_REQUEST_URI);

    if (requestedURI == null) {
        requestedURI = "some/default/home.xhtml";
    }
}

public void submit() throws IOException {
    // ...

    try {
        request.login(username, password);
        externalContext.redirect(requestedURI);
    } catch (ServletException e) {
        context.addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                "Bad login", null));
    }
}