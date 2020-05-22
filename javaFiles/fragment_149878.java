public class XMLView extends AbstractView {

  private final Document _xml;

  public XMLView(final Document xml) {
    _xml = xml;
  }

  @Override
  protected void renderMergedOutputModel(final Map<String, Object> model, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
    response.setContentType("application/xml");
    response.setCharacterEncoding("UTF-8");
    // do stuff to serialize _xml to response.getOutputStream()
   }
}