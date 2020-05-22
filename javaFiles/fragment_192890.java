public class SubscribedTopicListCell extends ListCell<String> {

    private final Label lSubscribedTopic = new Label();
    private final Button btnUnsubscribe = new Button();

    private static final Image image = new Image("resources/images/cross.png");

    private final ImageView ivBtnGraphic = new ImageView(image);

    private final GridPane listCellPane = new GridPane();

    public SubscribedTopicListCell() {
            btnUnsubscribe.setOnAction(e -> 
                MqttConnection.getInstance().unsubscribe(getItem())
            );
            this.setOnMouseEntered(e ->
                btnUnsubscribe.setVisible(true)
            );
            this.setOnMouseExited(e -> 
                btnUnsubscribe.setVisible(false)
            );
            listCellPane.add(lSubscribedTopic, 0, 0);
            listCellPane.add(btnUnsubscribe, 1, 0);
            ColumnConstraints col0 = new ColumnConstraints();
            col0.setHalignment(HPos.LEFT);
            ColumnConstraints col1 = new ColumnConstraints();
            col1.setHalignment(HPos.RIGHT);
            col1.setHgrow(Priority.ALWAYS);
            listCellPane.getColumnConstraints().addAll(col0, col1);
            btnUnsubscribe.setVisible(false);
            btnUnsubscribe.setGraphic(ivBtnGraphic);
            btnUnsubscribe.setBackground(Background.EMPTY);
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        setGraphic(null);
        if (!empty && item != null) {
            lSubscribedTopic.setText(item);
            setGraphic(listCellPane);
        }
    }
}