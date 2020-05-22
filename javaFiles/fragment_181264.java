public class ToolTip extends SmartPopup {
    public ToolTip(String message) {
        addStyleName("tool-tip-css");
        add(new Label(message));
    }
}