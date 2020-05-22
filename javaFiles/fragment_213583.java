interface IVisitor {
}

interface IRouterVisitor extends IVisitor {
  void visit(Router router);
}

interface INetworkCardVisitor extends IVisitor {
}

interface IWirelessNetworkCardVisitor extends INetworkCardVisitor {
  void visit(WirelessNetworkCard card);
}

interface IWiredNetworkCardVisitor extends INetworkCardVisitor {
  void visit(WiredNetworkCard card);
}