tabSet.addCloseClickHandler(new com.smartgwt.client.widgets.tab.events.CloseClickHandler() {

    @Override
    public void onCloseClick(TabCloseClickEvent event) {
        event.cancel();

        final Tab tab = event.getTab();

        SC.confirm("Are you sure? You want to delete " + tab.getTitle()+" tab.",
                new BooleanCallback() {

                    @Override
                    public void execute(Boolean value) {
                        if (value != null && value) {
                            tabSet.removeTab(tab);
                        }

                    }
                });

    }
});