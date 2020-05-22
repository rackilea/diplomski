public void updateItem(ComboBoxItem item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setText(null);
                setDisable(false);
                pseudoClassStateChanged(header, false);
            } else {
                setText(item.toString());
                setDisable(! item.isSelectable());
                pseudoClassStateChanged(header, ! item.isSelectable());
            }
        }