public class Parent {

    private ReadOnlyBooleanWrapper total = new ReadOnlyBooleanWrapper();
    private ObservableList<Child> children = 
        FXCollections.observableArrayList(c -> new Observable[] {c.singleProperty()});

    public Parent() {
        total.bind(Bindings.createBooleanBinding(() -> 
            children.stream().anyMatch(Child::isSingle), children);
    }

    public ReadOnlyBooleanProperty totalProperty() {
        return total.getReadOnlyProperty();
    }

    public ObservableList<Child> getChildren() {
        return children ;
    }

}