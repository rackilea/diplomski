public class Foo {
    private final StringProperty foo = new SimpleStringProperty();

    public String getFoo() {
        return foo.get();
    }

    public StringProperty fooProperty() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo.set(foo);
    }
}

public class FooController {
    @FXML
    private TextField fooTextField;

    private final Foo foo = new Foo();

    @FXML
    public void initialize() {
        foo.fooProperty().bindBidirectional(fooTextField.textProperty());
    }
}