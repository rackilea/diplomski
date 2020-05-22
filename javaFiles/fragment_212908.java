public class TestApplication extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }


    public void start(final Stage stage) {
        stage.setResizable(true);

        TestTableView table = new TestTableView();
        ObservableList<String> items = table.getItems();
        items.add("this,is,short,list");
        items.add("this,is,long,list,it,just,keeps,going,on,and,on,and,on");

        Scene scene = new Scene(table, 400, 200);
        stage.setScene(scene);

        stage.show();
    }


    /**
     * Note: this does not take into account font or any styles.
     * <p>
     * You might want to modify this to put the text in a label, apply fonts and css, layout the label,
     * then get the width.
     */
    private static double calculatePixelWidthOfString(String str) {
        return new Text(str).getBoundsInLocal().getWidth();
    }

    public class TestTableView extends TableView<String> {

        public TestTableView() {
            final TableColumn<String, CsvString> column = new TableColumn<>("COL1");
            column.setCellValueFactory(cdf -> {
                return new ReadOnlyObjectWrapper<>(new CsvString(cdf.getValue()));
            });
            column.setCellFactory(col -> {
                return new TableCell<String, CsvString>() {

                    @Override
                    protected void updateItem(CsvString item, boolean empty) { 
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {

                            String text = item.getText();
                            // get the width, might need to tweak this.
                            double textWidth = calculatePixelWidthOfString(text);
                            // might want to compare against current cell width
                            if (textWidth > 100) {
                                // modify the text here
                                text = item.getNumElements() + " elements";
                            }

                            setText(text);
                        }
                    }
                };
            });
            this.getColumns().add(column);
        }
    }

    private static class CsvString {

        private final String text;
        private final String[] elements;


        public CsvString(String string) {
            Objects.requireNonNull(string);
            this.text = string;
            this.elements = string.split(" *, *");
        }


        public int getNumElements() {
            return elements.length;
        }


        public String getText() {
            return text;
        }
    }
}