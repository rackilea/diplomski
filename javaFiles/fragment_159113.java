Date payDate =  mapOfIntAndListOfObjects.getOrDefault(spn, Collections.emptyList())
        .stream()
        .findFirst()
        .orElse(new MyObject())
        .getPayDate();
logger.info("paydate {} ", paydate);
return payDate;