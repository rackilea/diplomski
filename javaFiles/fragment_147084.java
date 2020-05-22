public class ScrumBoardLayout extends VerticalLayout implements ScrumBoard.SwitchChangeListener {

    private Label icon = new Label();
    private Switch mySwitch = new Switch();

    public ScrumBoardLayout() {
        setMargin(true);
        setSpacing(true);
        addHeader();

        // listen for state changes
        ScrumBoard.addSwitchChangeListener(this);
    }

    private void addHeader() {
        mySwitch.setImmediate(true);
        icon.setSizeUndefined();

        // notify of state change
        mySwitch.addValueChangeListener((Property.ValueChangeListener) event -> ScrumBoard.updateState((Boolean) event.getProperty().getValue()));

        VerticalLayout layout = new VerticalLayout();
        layout.setHeight("78%");
        layout.addComponents(icon, mySwitch);

        layout.setComponentAlignment(icon, Alignment.BOTTOM_CENTER);
        layout.setComponentAlignment(mySwitch, Alignment.BOTTOM_CENTER);
        layout.setExpandRatio(mySwitch, 1);
        addComponents(layout);
    }

    @Override
    public void handleStateChange(SwitchState state) {
        // update UI on state change
        UI.getCurrent().access(() -> {
            mySwitch.setValue(state.getValue());
            icon.setIcon(state.getIcon());
            Notification.show(state.name(), Type.ASSISTIVE_NOTIFICATION);
        });
    }

    @Override
    public void detach() {
        super.detach();
        ScrumBoard.removeSwitchListener(this);
    }
}