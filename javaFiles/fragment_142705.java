public class HtmlUnitDriverExt extends HtmlUnitDriver { 
  public HtmlUnitDriverExt(BrowserVersion version) {
    super(version);
  }
  @Override
  protected WebClient modifyWebClient(WebClient client) {
    client.setRefreshHandler(new RefreshHandler());
    return client;
  }
}