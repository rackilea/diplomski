Result result = new Result();
List<WpfPaymentAttributes> attributes = entityManager.createQuery(
    // query should be parameterized
    "select a from WpfPaymentAttributes a where global_key = 12333" 
).getResultList();
for (WpfPaymentAttributes attribute : attributes) {
    String value = attribute.getValue();
    switch(attribute.getName()) {
        case "name":
            result.setName(value);
            break;
        case "usage":
            result.setUsage(value);
            break;
        default:
            throw new IllegalStateException();
    }
} 
return result;