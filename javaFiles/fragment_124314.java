@FXML private GridPane gridPaneFirstTab;
@FXML private GridPane gridPaneSecondTab;

private List<Text> textCallbacksList1 = new ArrayList<>();
private List<Text> textCallbacksList2 = new ArrayList<>();
private final List<String> callbackNames = Arrays.asList(
    "text1",
    "text2",
    "text3"
);

Text text1, text2;
for (int i = 0; i < callbackNames.size(); ++i) {
    text1 = new Text(MessagesBundle.getString(callbackNames.get(i)));
    text2 = new Text(MessagesBundle.getString(callbackNames.get(i)));
    textCallbacksList1.add(text1);
    textCallbacksList2.add(text1);

    gridPaneFirstTab.getChildren().add(text1);
    gridPaneSecondTab.getChildren().add(text2);

    gridPaneFirstTab.setConstraints(text1, 0, i + 1);
    gridPaneSecondTab.setConstraints(text2, 0, i + 1);
}