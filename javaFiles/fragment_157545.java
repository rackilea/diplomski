@Autowired
private HttpServletRequest request;

@Override
public SessionContext getSessionContext() {
    return (SessionContext) request.getAttribute("mySessionContext");
}