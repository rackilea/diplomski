private String NAME = "John";
private String CITY = "New York";
private String ADDRESS = "Central Park";

public String getValue(property pro) {
    switch (pro) {
    case NAME:
        return NAME;
    case CITY:
        return CITY;
    case ADDRESS:
        return ADDRESS;
    }
    return null;
}