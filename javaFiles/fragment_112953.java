public static class Item {

    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public Item(BigDecimal price) {
        this.price = price;
    }
}

@Override
public void start(Stage primaryStage) {
    TableView<Item> table = new TableView<>();
    TableColumn<Item, BigDecimal> column = new TableColumn<>();
    column.setCellValueFactory(new PropertyValueFactory<>("price"));
    column.setCellFactory(new Callback<TableColumn<Item, BigDecimal>, TableCell<Item, BigDecimal>>() {

        private final Font font = Font.font("monospaced");
        private final BigDecimal hundred = BigDecimal.valueOf(100);
        private final char decimalSeparator = DecimalFormatSymbols.getInstance().getDecimalSeparator();

        @Override
        public TableCell<Item, BigDecimal> call(TableColumn<Item, BigDecimal> param) {
            return new TableCell<Item, BigDecimal>() {

                {
                    setAlignment(Pos.BASELINE_RIGHT);
                    setFont(font);
                }

                @Override
                protected void updateItem(BigDecimal item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText("");
                    } else {
                        BigInteger num = item.toBigInteger();
                        int frac = item.movePointRight(2).abs().remainder(hundred).intValue();
                        String numPart = String.format("%,d", num) + decimalSeparator;

                        setText(numPart + (frac == 0 ? "- " : String.format("%02d", frac)));
                    }
                }

            };
        }
    });

    table.getColumns().add(column);

    table.getItems().addAll(
            new Item(new BigDecimal("2")),
            new Item(new BigDecimal("2.5")),
            new Item(new BigDecimal("5555.99")),
            new Item(new BigDecimal("123456789.77")),
            new Item(new BigDecimal("22011.05")),
            new Item(new BigDecimal("4211"))
    );

    Scene scene = new Scene(table);

    primaryStage.setScene(scene);
    primaryStage.show();
}