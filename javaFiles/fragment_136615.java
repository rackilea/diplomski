@Inject HttpServletRequest request;

public CurrentTransaction() {
    // field injection has not yet taken place here
}

@PostConstruct
public void init() {
    // the injected request is now available
    this.user = request.getHeader("user");
    this.token = request.getHeader("token");
}