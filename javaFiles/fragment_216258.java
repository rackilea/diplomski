List<Condition> conditions = Arrays.asList(
    new Condition(sf -> sf.getSearchToken() != null,
                  sf -> emp -> emp.getFName().equalsIgnoreCase(sf.getSearchToken()) && emp.getLName().equalsIgnoreCase(sf.getSearchToken())),
    new Condition(sf -> ObjectUtils.allNotNull(sf.getFname(), sf.getLname(), sf.getType()),
                  sf -> emp-> emp.getFName().equalsIgnoreCase(sf.getFname()) && emp.getLName().equalsIgnoreCase(sf.getLname()) && emp.getType().equalsIgnoreCase(sf.getType()))
    //...
);