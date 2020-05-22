package de.jotschi.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TestMapper2 {

    private InjectableValues getInjectableValue(final Map<String, String> dataMap) {

        InjectableValues values = new InjectableValues() {

            @Override
            public Object findInjectableValue(Object valueId, DeserializationContext ctxt, BeanProperty forProperty, Object beanInstance) {
                if ("data".equals(valueId.toString())) {
                    return dataMap;
                }
                return null;
            }
        };
        return values;

    }

    @Test
    public void testMapper() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule idAsRefModule = new SimpleModule("ID-to-ref", new Version(1, 0, 0, null));

        idAsRefModule.addDeserializer(Entity.class, new JsonDeserializer<Entity>() {
            @Override
            public Entity deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

                Map<String, String> dataMap = (Map) ctxt.findInjectableValue("data", null, null);
                ObjectMapper mapper = (ObjectMapper) jp.getCodec();
                ObjectNode obj = (ObjectNode) mapper.readTree(jp);
                String type = obj.get("typeName").asText();
                dataMap.put("typeName", type);
                return mapper.setInjectableValues(getInjectableValue(dataMap)).treeToValue(obj, EntityImpl.class);
            }
        });

        idAsRefModule.addDeserializer(TestField.class, new JsonDeserializer<TestField>() {
            @Override
            public TestField deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
                // Access type from context
                Map<String, String> dataMap = (Map) ctxt.findInjectableValue("data", null, null);
                System.out.println("Type name: " + dataMap.get("typeName"));

                ObjectMapper mapper = (ObjectMapper) p.getCodec();
                ObjectNode obj = (ObjectNode) mapper.readTree(p);

                // Custom deserialisation
                TestField field = new TestField();
                field.setName(obj.get("name").asText());
                // Delegate further deserialisation to other mapper
                field.setSubField(mapper.setInjectableValues(getInjectableValue(dataMap)).treeToValue(obj.get("subField"), SubField.class));
                return field;
            }
        });

        mapper.registerModule(idAsRefModule);
        mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // Setup the pojo
        EntityImpl impl = new EntityImpl();
        impl.setTypeName("test");
        TestField testField = new TestField();
        testField.setName("42");
        SubField subField = new SubField();
        subField.setName("sub");
        testField.setSubField(subField);
        impl.setField(testField);

        // POJO -> JSON
        String json = mapper.writeValueAsString(impl);
        System.out.println(json);

        // JSON -> POJO
        Entity obj = mapper.reader(getInjectableValue(new HashMap<String, String>())).forType(Entity.class).readValue(json);
        assertNotNull("The enity must not be null", obj);
        assertNotNull(((EntityImpl) obj).getField());
        assertEquals("42", ((EntityImpl) obj).getField().getName());
        assertNotNull(((EntityImpl) obj).getField().getSubField());
        assertEquals("sub", ((EntityImpl) obj).getField().getSubField().getName());
        System.out.println(obj.getClass().getName());

    }

}