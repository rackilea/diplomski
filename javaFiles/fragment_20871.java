@Route
public class MainView extends VerticalLayout {
    public MainView(CustomerService customerService) { // customerService will be injected
        CustomerForm customerForm = new CustomerForm(customerService);
        add(customerForm);
    }
}