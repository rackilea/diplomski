final DecoratedPopupPanel simplePopup = new DecoratedPopupPanel(true);
    dataTable.addCellPreviewHandler(new CellPreviewEvent.Handler<Alert>() {
        @Override
        public void onCellPreview(CellPreviewEvent<Alert> alertCellPreviewEvent) {
            if ("mouseover".equals(alertCellPreviewEvent.getNativeEvent().getType())
                    && alertCellPreviewEvent.getColumn() == 5
                    && alertCellPreviewEvent.getValue().getNote() != null) {
                // using hard-coded column number isn't the most elegant solution, but it's ok for now.
                int left = alertCellPreviewEvent.getNativeEvent().getClientX();
                int top = alertCellPreviewEvent.getNativeEvent().getClientY();
                simplePopup.setWidget(new HTML(alertCellPreviewEvent.getValue().getNote()));
                simplePopup.setPopupPosition(left, top);
                simplePopup.show();
            } else {
                simplePopup.hide();
            }
        }
    });