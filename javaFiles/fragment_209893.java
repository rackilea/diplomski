jaxbContext.setValueByXPath( person, "first/text()", null, "Tres");
    jaxbContext.setValueByXPath( person, "last/text()", null, "Bailey");

    Object address = jaxbContext.createByXPath(person, "address", null, Object.class);
    jaxbContext.setValueByXPath(person, "address", null, address);

    jaxbContext.setValueByXPath( person, "address/city/text()", null, "Cowpens");
    jaxbContext.setValueByXPath( person, "address/state/text()", null, "SC");