@DefaultProperty(value = "children")
public class MyNewComponent extends Parent {

    @Override
    public ObservableList<Node> getChildren() {
        return super.getChildren();
    }

    public String setSpecificAttribute(String str) {
        // Do something here...
    }
}