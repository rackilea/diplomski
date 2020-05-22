@Route
public class MainView extends VerticalLayout {
    public MainView(CustomerForm customerForm) {  // customerForm will be injected
        add(customerForm);
    }
}