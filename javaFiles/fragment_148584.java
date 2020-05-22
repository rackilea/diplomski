public class CustomFeedbackPanel extends FencedFeedbackPanel {

    [...]

    @Override
    public void onEvent(IEvent<?> event) {
        // Always re-render the feedback panel input during ajax requests if it contains messages
        if (event.getPayload() instanceof AjaxRequestTarget && anyMessage()) {
            ((AjaxRequestTarget) event.getPayload()).add(this);
        }
    }
}