public static class MyPathSpecCreator implements WebSocketCreator
{
    private static final String PATHSPEC_KEY = PathSpec.class.getName();

    @Override
    public Object createWebSocket(ServletUpgradeRequest upgradeRequest,
                                  ServletUpgradeResponse upgradeResponse)
    {
        String pathSpecPattern = "/"; // default value (pick your own)
        PathSpec pathSpec = (PathSpec) upgradeRequest.getServletAttribute(PATHSPEC_KEY);
        if(pathSpec != null)
            pathSpecPattern = pathSpec.getDeclaration();
        return new MyWebSocketAdapter(pathSpecPattern);
    }
}