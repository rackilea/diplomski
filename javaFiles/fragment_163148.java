import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

public class Cars {

    public static void main(String[] args) throws Exception {
        SimpleModule carsModule = new SimpleModule("CarsModule");
        carsModule.addSerializer(Lamborghini.class, new CustomCarSerializer<>(Lamborghini.class));
        carsModule.addSerializer(Ferrari.class, new CustomCarSerializer<>(Ferrari.class));

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(carsModule);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        System.out.println(mapper.writeValueAsString(new Store()));
    }
}