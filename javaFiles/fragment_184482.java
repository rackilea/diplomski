@JavaScript({"mycomponent-connector.js"})
public class MyComponent extends AbstractJavaScriptComponent {

    @Override
    protected MyComponentState getState() {
        return (MyComponentState) super.getState();
    }
}