public class MyPojo {
    public String someString;  // made properties into public for this example...
    public AnotherPojo someOtherPojo;
    public Object value;

    @JsonAnySetter
    public void setValue(String name, Object value) {
        System.out.println(name + " " + value.getClass());
        System.out.println(value);

        // basic validation
        if (name.startsWith("value") && value instanceof Map) {
            String className = "com.company." + name.substring("value".length());
            System.out.println(name + " " + value.getClass() + " " + className);
            System.out.println(value);
            try {
                // nice of Jackson to be able to deserialize Map into Pojo :)
                ObjectMapper mapper = new ObjectMapper();
                this.value = mapper.convertValue(value, Class.forName(className));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(this.value + " " + this.value.getClass());
        }

    }
}

public class AnotherPojo {
    public String someOtherProperty;
}

public class CodeableConcept {
    public String text;
    public Code[] coding;
}

public class Code {
    public String code;
}