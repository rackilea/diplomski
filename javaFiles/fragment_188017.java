final Price p1 = new Price(4);
final Price p2 = new Price(5);
final Price p3 = new Price(6);

final CellTable<Price> table = new CellTable<Price>();

Column<Price, String> priceColumn = new Column<Price, String>(new TextInputCell()) {
    public String getValue(Price p) {
    if (p.getPrice() == 0)
        return "";
    return p.getPrice() + "";
    }
};

ListDataProvider<Price> dataProvider = new ListDataProvider<Price>();
dataProvider.addDataDisplay(table);

List<Price> list = dataProvider.getList();
list.add(p1);
list.add(p2);
list.add(p3);

table.addColumn(priceColumn);

Button b = new Button("refresh");
b.addClickHandler(new ClickHandler() {

    @Override
    public void onClick(ClickEvent event) {
    // your refresh logic, update the items already loaded into the CellTable!
    p2.setPrice(1000);
    p3.setPrice(2000);

    table.redraw();
    }
});

RootPanel.get().add(table);
RootPanel.get().add(b);