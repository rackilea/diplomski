import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        SimpleModule customModule = new SimpleModule();
        customModule.addDeserializer(Test.class, new TestMapper("Extra value!!!"));

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(customModule);

        Test test = new Test();
        test.setValue("Value");

        String json = mapper.writeValueAsString(test);
        System.out.println(json);
        System.out.println(mapper.readValue(json, Test.class));
    }
}

class TestMapper extends StdDeserializer<Test> {

    private String extraConfig;

    public TestMapper() {
        this(null);
    }

    public TestMapper(String extraConfig) {
        super(Test.class);
        this.extraConfig = extraConfig;
    }

    @Override
    public Test deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Test test = new Test();
        test.setValue(extraConfig);

        return test;
    }
}

class Test {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Test{" +
                "value='" + value + '\'' +
                '}';
    }
}