public class ButtonWithIconOnTheRightComponent extends VerticalLayout {
    public ButtonWithIconOnTheRightComponent() {
        // text filed to specify icon URL
        TextField urlField = new TextField("Icon URL", "http://files.softicons.com/download/toolbar-icons/status-icons-set-by-iconleak/png/16x16/30.png");

        // button which updates its icon using the URL specified in the text field above
        Button button = new Button("Update icon", event -> event.getButton().setIcon(new ExternalResource(urlField.getValue())));

        // use valo style to align icon to the right
        button.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_RIGHT);

        // add components to the UI
        addComponents(urlField, button);
        setSpacing(true);
    }
}