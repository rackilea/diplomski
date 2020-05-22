public class AjaxUpdateEvent {
    private final AjaxRequestTarget target;

    public AjaxUpdateEvent(AjaxRequestTarget target) {
        this.target = target;
    }
    public AjaxRequestTarget getAjaxRequestTarget() {
        return target;
    }
}