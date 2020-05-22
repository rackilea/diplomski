@JsonTypeInfo(
      use = JsonTypeInfo.Id.NAME, 
      include = JsonTypeInfo.As.PROPERTY, 
      property = "type")
    @JsonSubTypes({ 
      @Type(value = A.class, name = "a"), 
      @Type(value = B.class, name = "b") 
    })
    public class C {
        private String a;
        private String b;
        private String c;
    }

    public class A extends C {
        private SomeObject z;
    }

    public class B extends C {
        private OtherObject z;
        private Integer y;
    }

    // example of usage
    A a = new A();
    B b = new B();