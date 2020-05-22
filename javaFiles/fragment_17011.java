public Consumer(EPServiceProvider epsp) {
    EPStatement statement = epsp.getEPAdministrator().createEPL(input);
    statement.setSubscriber(this);
}
public void update(A event) {
    System.out.println("Consumer received event!");    
}