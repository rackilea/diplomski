// initialize the tooltips & default labels
mWidgetInfo.forEach((k, v)-> {
    // no need to switch on the service
    // disable click events on the checkboxes
    // as they should be read only
    v.forEach((k1, widgetPair)-> {
        widgetPair.getKey().setTooltip(
            new Tooltip("Connect ID"));
        CheckBox checkBox = widgetPair.getValue();
        checkBox.setTooltip(new Tooltip("Servicing Connection"));
        checkBox.setOpacity(1);
    });
});