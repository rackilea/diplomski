public void preRemove(){
    List<Customer> tempList = new ArrayList(customers);
    for(Customer c : tempList){
        c.setCustomerStatus(null); 
    }
}