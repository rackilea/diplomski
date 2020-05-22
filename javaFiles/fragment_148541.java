ArrayList<Customer> list = generateFromFile("Week3ProgrammingDataUpdate.csv");
     ArrayList<Customer> customersOver65 = new ArrayList<Customer>();
    for(Custumer customer: list ){
        if (Customer.eligibleForRetirement(customer)){
        customersOver65.add(customer);

    }
    System.out.println(customersOver65);
}