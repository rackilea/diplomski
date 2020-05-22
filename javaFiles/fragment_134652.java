TableColumn<DebuggerItem, ImageView> iconColumn = new TableColumn<>("ICON");
TableColumn<DebuggerItem, String> typeColumn = new TableColumn<>("TEXT");
TableColumn<DebuggerItem, String> textColumn = new TableColumn<>("DATA");
// Fixed size column
iconColumn.setPrefWidth(40);
iconColumn.setMinWidth(40);
iconColumn.setMaxWidth(40);
iconColumn.setResizable(false);
// Predefined preferred size of 100px
typeColumn.setPrefWidth(100);
// Automatic width for last column
textColumn.prefWidthProperty().bind(
    widthProperty().subtract(
       iconColumn.widthProperty()).subtract(
       typeColumn.widthProperty()).subtract(2)
);
getColumns().addAll(iconColumn, typeColumn, textColumn);