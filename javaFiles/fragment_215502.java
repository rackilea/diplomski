@Component(servicefactory = true)
public class MyComponent {

    @Activate
    public void activate(ComponentContext context) {
        Bundle consumer = context.getUsingBundle();
        // ...
    }
}