public class CallFromJavascriptBehavior extends AbstractDefaultAjaxBehavior {
@Override
protected void respond(AjaxRequestTarget target) {
    final StringValue parameterValue = RequestCycle.get().getRequest().getQueryParameters().getParameterValue("yourName");
    System.out.println(String.format("Hello %s", parameterValue.toString()));
}

@Override
public void renderHead(Component component, IHeaderResponse response) {
    super.renderHead(component, response);
    response.render(JavaScriptHeaderItem.forScript(String.format("nameOfFunction=%s", getCallbackFunction(CallbackParameter.explicit("yourName"))), "CallFromJavascriptBehavior"));
}}