public PropertyChangeInterceptor() {
   //listeners = new HashMap<>(); 
   //listeners.put(Customer.class, new CustomerChangeListener());
}

@PostConstruct
public void init() {
    StaticDelegateInterceptor.setInterceptor(this);
    listeners = new HashMap<>(); //move to here
    listeners.put(Customer.class, customerChangeListener);
}