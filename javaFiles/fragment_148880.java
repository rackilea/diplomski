public class AutoIndexTestServer implements Neo4jServer {

    final String uri;

    public AutoIndexTestServer() {
        try {
            ServerControls controls = TestServerBuilders.newInProcessBuilder()
                    .withConfig("dbms.security.auth_enabled", "false")
                    .withConfig("node_auto_indexing", "true")
                    .withConfig("node_keys_indexable", "title")
                    .newServer();
            uri = controls.httpURI().toString();

        }
        catch (Exception e) {
            throw new RuntimeException("Could not start inprocess server",e);
        }
    }

    @Override
    public String url() {
        return uri;
    }

    @Override
    public String username() {
        return null;
    }

    @Override
    public String password() {
        return null;
    }
}