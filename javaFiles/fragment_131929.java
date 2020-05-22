public class ClientListCell extends ListCell<Client> {
    private final TextField textField = new TextField();

    public ClientListCell() {
        textField.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                cancelEdit();
            }
        });
        textField.setOnAction(e -> {
            getItem().setName(textField.getText());
            setText(textField.getText());
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        });
        setGraphic(textField);
    }

    @Override
    protected void updateItem(Client client, boolean empty) {
        super.updateItem(client, empty);
        if (isEditing()) {
            textField.setText(client.getName());
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        } else {
            setContentDisplay(ContentDisplay.TEXT_ONLY);
            if (empty) {
                setText(null);
            } else {
                setText(client.getName());
            }
        }
    }

    @Override
    public void startEdit() {
        super.startEdit();
        textField.setText(getItem().getName());
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        textField.requestFocus();
        textField.selectAll();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setText(getItem().getName());
        setContentDisplay(ContentDisplay.TEXT_ONLY);
    }
}