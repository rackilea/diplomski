public static enum FooClassEnum
{
    Foo1("foo1", FOO1.class),
    Foo2("foo2", FOO2.class),
    Foo3("foo3", FOO3.class);

    private final Class myClass;
    private final String jsonType;

    FooClassEnum(String jsonType, Class myClass){
        this.myClass = myClass;
        this.jsonType = jsonType;
    }

    public static FooClassEnum get(String jsonType) {
        for (FooClassEnum ft : values())
            if (ft.getJsonType().equals(jsonType))
                return ft;
        return null;
    }

    public Class getFooClass() { 
        return myClass; 
    }

    public String getJsonType() {
        return jsonType;
    }
}