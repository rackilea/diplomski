import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Create own annotation storing your unit value

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@interface Unit {
    String value();
}

// Create custom serializer checking @Unit annotation

class UnitSerializer extends StdSerializer<Integer> implements ContextualSerializer {

    private String unit;

    public UnitSerializer() {
        super(Integer.class);
    }

    public UnitSerializer(String unit) {
        super(Integer.class);
        this.unit = unit;
    }

    @Override
    public void serialize(Integer value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeString(String.format("%d %s", value, unit));
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        String unit = null;
        Unit ann = null;
        if (property != null) {
            ann = property.getAnnotation(Unit.class);
        }
        if (ann != null) {
            unit = ann.value();
        }
        return new UnitSerializer(unit);
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Data
class X {
    @JsonSerialize(using = UnitSerializer.class)
    @Unit("mm")
    private int length;
}

public class Runner {
    public static void main(String[] args) throws JsonProcessingException {

        X x = new X(10);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(x));
    }
}