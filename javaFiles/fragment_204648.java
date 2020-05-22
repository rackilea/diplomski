class MainController {
  private static final Logger log = Logger.getLogger(MainController.class);

  public MainController() {
    log.info("creating MainController@" + Integer.toHexString(hashCode()));
    EventBusFactory.getEventBusInstance().register(this);
  }

  @Subscribe
  public void addFacetEvent(final FacetAddedEvent event) {
    final String signature = "MC@" + Integer.toHexString(hashCode()) + ": ";
    log.info("addFacetEvent in " + signature + event);
    // getTreeTableViewBuilder returns extended ArrayList with fancy add
    getTreeTableViewBuilder().addFacetToList(signature + event.getData());
  }

  // plus other stuff like toString etc.
}