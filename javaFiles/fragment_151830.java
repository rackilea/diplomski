class A {

    @JsonSerialize(using = C1Serializer.class)
    C c;

    B b;
} 

class B {
    @JsonSerialize(using = C2Serializer.class)
    C c;
}

// you can do a lot of stuff in a custom serializer
class C1Serializer extends JsonSerializer<C> {

    static class FirstTwoFields {
        int c1
        int c2
        public FirstTwoFields(C c) {
            c1 = c.c1;
            c2 = c.c2;
        }

        //   getter and setters or delegate c's instead
        // .......
    }

    public void serialize(C c,
                      JsonGenerator jgen,
                      SerializerProvider provider){
        jgen.writeObject(new FirstTwoFields(c));
    }

}