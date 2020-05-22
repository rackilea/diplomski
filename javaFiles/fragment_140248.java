private String generateSomeName() {
    String basicProjectName = "Sth" + Optional.ofNullable(method1())
                                              .filter(s -> s.length() > 0)
                                              .map(s -> "_" + s)
                                              .orElse("");
    return basicProjectName + "_X" ;
}

private String method1() {
    try {
        Class.getNumber();  //returns String1 
    } catch (Exception e) {
        log.warn("Unable to get this Number", e);
    }
    return "";            
}