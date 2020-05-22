public Customer richestCustomer(){
    if(customerCount <= 0) {
        return null; // or throw exception
    }
    Customer richest = customers[0];
    for(int i = 1; i < customerCount; i++){
        if(customers[i].hasMoreMoneyThan(richest)){
            richest = customers[i];
        }
    }
    return richest;
}