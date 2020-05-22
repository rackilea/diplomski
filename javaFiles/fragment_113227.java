interface ConfigurablePort extends Port {
   void setValue();
}

// in some factory... Or perhaps in the Node itself?
public Port createPortForNode(Node node) {
   ConfigurablePort port = new Port();
   node.setPort(port);  // as Configurable
   return port; // as immutable
}