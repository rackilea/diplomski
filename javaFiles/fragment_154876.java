Predicate<Customer> customerPredicate = reducePredicates(cusPredicates);
Predicate<Customer> insurancePredicate = reducePredicates(insPredicates);
List<Insurance> = 
    customers.stream()
             .filter(customerPredicate)
             .flatMap(cus -> cus.getInsurances().stream())
             .filter(insurancePredicate)
             .collect(Collectors.toList())