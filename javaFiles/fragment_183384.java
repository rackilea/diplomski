private CustomerService service;

@Autowired
public MainView(CustomerService service) {
    this.service = service;
    ...
}