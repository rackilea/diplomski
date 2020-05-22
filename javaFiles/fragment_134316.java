public class DontLeaveBehavior extends AbstractBehavior{

    /**
     * {@inheritDoc}
     */
    @Override
    public void renderHead(final IHeaderResponse response){
        response.renderJavascriptReference(new JavascriptResourceReference(DontLeaveBehavior.class,
            "DontLeaveBehavior.js"));
        response.renderOnDomReadyJavascript("initwindowdirty();");
        super.renderHead(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void bind(final Component component){
        super.bind(component);
        component.setOutputMarkupId(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onRendered(final Component component){
        final Response response = RequestCycle.get().getResponse();
        response.write(JavascriptUtils.SCRIPT_OPEN_TAG);
        response.write("monitor('" + component.getMarkupId() + "');");
        response.write(JavascriptUtils.SCRIPT_CLOSE_TAG);
    }

}