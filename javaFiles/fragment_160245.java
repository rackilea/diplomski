public A<?> foo(String json) {
    Class<?> c = Class.forName(getTypeFromJson(json)); //this will load the class of the required type
    Object o = parseJson(json); //say this parses the json and returns some object according to it
    A a = new A(c.cast(o));
    return a;
)