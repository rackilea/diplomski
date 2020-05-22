class MyListCell extends ListCell<MyObject>
{
    private final AnchorPane _myComponent;

    public MyListCell()
    {
        ...
        this.setPrefWidth(0);
        myComponent.prefWidthProperty().bind(this.widthProperty());
    }

    ...

    @Override
    protected void updateItem(MyObject item, boolean empty)
    {
        ...
        setGraphic(_myComponent);
        ...
    }
}