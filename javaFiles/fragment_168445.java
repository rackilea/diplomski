public class HtmlPanelBase extends Composite
{
  private String _dynPostfix = "";
  protected final String id(final String staticId) { return staticId + _dynPostfix; }
  private final String wrapId(final String id) { return "id=\"" + id + "\""; }
  private final String wrapDynId(final String refId) { return wrapId(id(refId)); }

  private String _htmlContentAsText = null;
  protected String getHtmlContentAsText() { return _htmlContentAsText; }

  private ArrayList<String> _idList = null;

  protected HTMLPanel _holder = null;
  private HTMLPanel createHtmlPanel(final boolean defineGloballyUniqueIds)
  {
    // HTML panel text containing the reference id's.
    if (defineGloballyUniqueIds)
    {
      // Replace the reference id's with dynamic/unique id's.
      for (String refId : _idList)
        _htmlContentAsText = _htmlContentAsText.replace(wrapId(refId), wrapDynId(refId));
    }
    // Return the HTMLPanel containing the globally unique id's.
    return new HTMLPanel(_htmlContentAsText);
  }

  public HtmlPanelBase(final String htmlContentAsText, final ArrayList<String> idList, final boolean defineGloballyUniqueIds)
  {
    _htmlContentAsText = htmlContentAsText;
    _idList = idList;
    this.setup(defineGloballyUniqueIds);
    super.initWidget(_holder);
  }

  public HtmlPanelBase(final String htmlContentAsText)
  {
    this(htmlContentAsText, null, false);
  }

  private void setup(final boolean defineGloballyUniqueIds)
  {
    if (defineGloballyUniqueIds)
      _dynPostfix = "_" + UUID.uuid().replace("-", "_");
    _holder = createHtmlPanel(defineGloballyUniqueIds);
  }
}