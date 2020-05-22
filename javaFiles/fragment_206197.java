// New Modifed code
Class Test
{
Type type = null;
public void setType(type)
{
this.type = type;
}

public static Type getType()
{
return type;
}

for (final Type type : category.getTypes()) {
    setType(type);
    TableColumn<Item, Integer> col = new TableColumn<Item, Integer>(type.getName());

    col.setCellValueFactory(new Callback<CellDataFeatures<Item>,
            ObservableValue<Integer>>() {
        @Override
        public void call(CellDataFeatures<Item> item) {
            return item.getValue().getPrice(Test.getType());
        }
    });
   priceColumn.add(col);
}
}