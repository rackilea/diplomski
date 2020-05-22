Pattern pattern = Pattern.compile("((?:[0-9]|[01][0-9]|2[0-3]):[0-5][0-9]\\s)(\\+\\d)");

departTimeCol.setCellFactory(column -> new TableCell<Ride, String>() {

    private final Text timeText = new Text();
    private final Text delayText = new Text();
    private final TextFlow flow = new TextFlow(timeText, delayText);

    {
        delayText.setFill(Color.RED);
        flow.setPrefHeight(0);
        flow.heightProperty().addListener((observable, oldValue, newValue) -> {
            this.setMinHeight(newValue.doubleValue() + 4);
        });
        flow.setMinHeight(Region.USE_COMPUTED_SIZE);
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        setGraphic(flow);
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            timeText.setText("");
            delayText.setText("");
            delayText.setVisible(false);
        } else {
            Matcher m = pattern.matcher(item);
            if (m.matches()) {
                timeText.setText(m.group(1));
                delayText.setText(m.group(2));
                delayText.setVisible(true);
            } else {
                timeText.setText(item);
                delayText.setText("");
                delayText.setVisible(false);
            }
        }

    }
});