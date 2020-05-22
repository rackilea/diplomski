public static Result apiCustomers(){
    List<Customer> customerList = Model.coll(Customer.class).find().toArray();
    List<String> emails = new ArrayList<String>();

    for(Customer c : customerList){
        emails.add(c.email);
    }

    return ok(Json.toJson(emails));
}