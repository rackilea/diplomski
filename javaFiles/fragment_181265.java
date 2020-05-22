yourButtonOrWhatever.addClickHandler(new ClickHandler() {

        @Override
        public void onClick(ClickEvent event) {
            ToolTip toolTip = new ToolTip("Hey, this is like a tool-tip for clicking!");
            toolTip.show(event.getClientX(), event.getClientY());
        }
    });