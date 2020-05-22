public static class ManagementServiceHandler implements ManagementService.Iface {

    private Map<Node,int> nodes;

    public ManagementServiceHandler() 
    {
        nodes = new Map<Node,int>()
    }

    /**
     * registers a node to a server, returning the port used
     */
    public int RegisterNode(Node hostAndService, int preferredPort) {
        int port = preferredPort;
        // TODO: check whether port can be used
        nodes.Add( hostAndService, port);
        return port;    
    }

    /**
     * lists all the services available at the moment.
     * Optionally specify host and/or service name to narrow the search
     */
    public Nodes GetNodes(String host, String svcname)  {
        var Nodes retval = new Nodes();
        retval.allNodes = new Map<Node,int>();

        for( var node : nodes) {
            if( (host.isEmpty() || (host == node.key.host)) {
                if( (svcname.isEmpty() || (svcname == node.key.serviceName)) {
                    retval.allNodes.add(node)
                }
            }
        }

        return retval;
    }
}