import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.Instant;

public class CustomInstantSerializer extends JsonSerializer<Instant> {

    @Override
    public void serialize(Instant o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(new EpochInstant(o));
    }

    public static class EpochInstant {

        private final long epochSecond;
        private final int nano;

        EpochInstant(Instant instant) {
            this.epochSecond = instant.getEpochSecond();
            this.nano = instant.getNano();
        }
    }
}