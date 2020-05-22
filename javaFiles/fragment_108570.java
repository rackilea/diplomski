import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JacksonIgnorePropertySerializationExceptions {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new SimpleModule().setSerializerModifier(new BeanSerializerModifier() {
            @Override
            public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {
                return beanProperties.stream().map(bpw -> new BeanPropertyWriter(bpw) {
                    @Override
                    public void serializeAsField(Object bean, JsonGenerator gen, SerializerProvider prov) throws Exception {
                        try {
                            super.serializeAsField(bean, gen, prov);
                        } catch (Exception e) {
                            System.out.println(String.format("ignoring %s for field '%s' of %s instance", e.getClass().getName(), this.getName(), bean.getClass().getName()));
                        }
                    }
                }).collect(Collectors.toList());
            }
        }));

        mapper.writeValue(System.out, new VendorClass());
    }

    public static class VendorClass {
        public String getNormalProperty() {
            return "this is a normal getter";
        }

        public Object getProblematicProperty() {
            throw new IllegalStateException("this getter throws an exception");
        }

        public String getAnotherNormalProperty() {
            return "this is a another normal getter";
        }
    }
}