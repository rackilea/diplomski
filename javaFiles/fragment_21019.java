@Override
    protected void updateItem(Double item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
            setTextFill(null);
            return;
        }
        setText(String.valueOf(item));
        setTextFill(fill);
    }