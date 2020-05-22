import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;

public class Test {
    public static void main(String[] args) {
        String jsonA = "{" +
                "\"some_field\": \"main_some_field1\"," +
                "\"content_type\": \"typeA\"," +
                "\"content\" : {" +
                "    \"some_field\" : \"content_some_field\"," +
                "    \"another_field\" : \"content_another_field\"" +
                "}}";

        String jsonB = "{" +
                "\"some_field\": \"main_some_field2\"," +
                "\"content_type\": \"typeB\"," +
                "\"content\" : {" +
                "    \"some_field_b\" : \"content_some_field_b\"," +
                "    \"another_field_b\" : \"content_another_field_b\"" +
                "}}";


        ObjectMapper mapper = new ObjectMapper();

        /*
         * This is another way to register the subTypes if you want to do it dynamically without the use of the
         * JsonSubTypes annotation in the ScheduledContent class
         */
//        mapper.registerSubtypes(new NamedType(ScheduledAContent.class, "typeA"));
//        mapper.registerSubtypes(new NamedType(ScheduledBContent.class, "typeB"));

        try {
            ScheduledContent scheduledAContent = mapper.readValue(jsonA, ScheduledContent.class);
            scheduledAContent.doSomethingWithContent();

            ScheduledContent scheduledBContent = mapper.readValue(jsonB, ScheduledContent.class);
            scheduledBContent.doSomethingWithContent();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}