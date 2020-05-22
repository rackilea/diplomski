struct Node {
  1: string hostName,
  2: string serviceName,
}

struct Nodes {
  1: map<Node, i32>  allNodes
}

service ManagementService {
  /** registers a node to a server, returning the port used */
  i32 RegisterNode(1 : Node hostAndService, 2 : i32 preferredPort)

  /** lists all the services available at the moment. 
      Optionally specify host and/or service name to narrow the search */
  Nodes GetNodes(1: string host, 2: string service)
}