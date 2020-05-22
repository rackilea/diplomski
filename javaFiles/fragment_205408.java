// doing the work twice
CustomerCategory category = findCategory(totalOrderValues(
     customer.getOrders(currentMonth)));
List<Promotion> eligiblePromotions = findEligiblePromotions(totalOrderValues(
     customer.getOrders(currentMonth)));

// ... becomes ...
BigInteger totalOrderValues = totalOrderValues(
    customer.getOrders(currentMonth))
CustomerCategory category = findCategory(totalOrderValues);
List<Promotion> eligiblePromotions = findEligiblePromotions(totalOrderValues);