enum Attribute {
    UPN("http://schemas.xmlsoap.org/ws/2005/05/identity/claims/upn") {
        void setValue(Principal principal, String value) {
            principal.setUpn(value);
        }
    },
    ...
    ;

    private final String name;

    private Attribute(String name) {
        this.name = name;
    }

    public abstract setValue(Principal principal, String name);

    public static Attribute getByName(String name) {
        for (Attribute attribute : values())
            if (attribute.name.equals(name))
                return attribute;

        return null;
    }

    public static void setByName(Principal principal, String name, String value) {
        Attribute attribute = getByName(name);

        if (attribute == null)
            throw new IllegalArgumentException("No such attribute");

        attribute.setValue(principal, value);
    }
}