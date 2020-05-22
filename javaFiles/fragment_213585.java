interface INetworkElement {
  void accept(IVisitor visitor);
}

class Router implements INetworkElement {
  @Override
  public void accept(IVisitor visitor) {
    if (visitor instanceof IRouterVisitor) {
      ((IRouterVisitor)visitor).visit(this);
    }
  }
}

interface INetworkCard extends INetworkElement {}

class WiredNetworkCard implements INetworkCard {
  @Override
  public void accept(IVisitor visitor) {
    if (visitor instanceof IWiredNetworkCardVisitor) {
      ((IWiredNetworkCardVisitor)visitor).visit(this);
    }
  }
}

class WirelessNetworkCard implements INetworkCard {
  @Override
  public void accept(IVisitor visitor) {
    if (visitor instanceof IWirelessNetworkCardVisitor) {
      ((IWirelessNetworkCardVisitor)visitor).visit(this);
    }
  }
}