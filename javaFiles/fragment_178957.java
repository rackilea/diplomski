Callback<TableColumn<Tabela, Double>, TableCell<Tabela, Double>> cellFactory =
    new Callback<TableColumn<Tabela, Double>, TableCell<Tabela, Double>>() {
public TableCell call(TableColumn<Tabela, Double> p) {
    return new TableCell<Tabela, Double>() {

        private ProgressBar pb = new ProgressBar();
        private Text txt = new Text();
        private HBox hBox = HBoxBuilder.create().children(pb, txt).alignment(Pos.CENTER_LEFT).spacing(5).build();
        @Override
        public void updateItem(Double item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                pb.setProgress(item);
                txt.setText("value: " + item);
                setGraphic(hBox);
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            }
        }
    };
}
};