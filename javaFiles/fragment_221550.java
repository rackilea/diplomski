public class LifecycleEvent {

public LifecycleEvent() {
    this(null, null, null, null);
}

public LifecycleEvent(
    HttpServletRequest request, HttpServletResponse response) {

    this(null, request, response, null);
}

public LifecycleEvent(HttpSession session) {
    this(null, null, null, session);
}

public LifecycleEvent(String[] ids) {
    this(ids, null, null, null);
}

public LifecycleEvent(
    String[] ids, HttpServletRequest request, HttpServletResponse response,
    HttpSession session) {

    _ids = ids;
    _request = request;
    _response = response;
    _session = session;
}

public String[] getIds() {
    return _ids;
}

public HttpServletRequest getRequest() {
    return _request;
}

public HttpServletResponse getResponse() {
    return _response;
}

public HttpSession getSession() {
    return _session;
}

private final String[] _ids;
private final HttpServletRequest _request;
private final HttpServletResponse _response;
private final HttpSession _session;}