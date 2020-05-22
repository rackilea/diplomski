public class ComponentBehavior extends AbstractDefaultAjaxBehavior{
@Override
protected void respond(AjaxRequestTarget target) {
    final StringValue parameterValue = RequestCycle.get().getRequest().getQueryParameters().getParameterValue("yourName");
    System.out.println(String.format("Hello %s", parameterValue.toString()));
}

@Override
public void renderHead(Component component, IHeaderResponse response) {
    super.renderHead(component, response);
    response.render(OnDomReadyHeaderItem.forScript(String.format("initMyComponent('#%s', %s)", component.getMarkupId(), getCallbackFunction(CallbackParameter.explicit("yourName")))));
}}