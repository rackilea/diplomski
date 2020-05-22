public class DialogButtonHandler {
  @Parameter(value = "dlgId", defaultPrefix = BindingConstants.LITERAL)
  private String dlgId;

  @Inject
  private JavaScriptSupport javaScriptSupport;

  @InjectContainer
  private ClientElement element;

  @AfterRender
  public void afterRender() {
    javaScriptSupport.addScript(
      "$('#%s').click(function(){$('#%s').dialog('close');});",
          element.getClientId(), dlgId);
  }}