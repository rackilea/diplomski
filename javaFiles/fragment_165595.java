ActionMapping mapping = prepare.findActionMapping(request, response, true);
if (mapping == null) {
    boolean handled = execute.executeStaticResourceRequest(request, response);
    if (!handled) {
        chain.doFilter(request, response);
    }
} else {
    execute.executeAction(request, response, mapping);
}