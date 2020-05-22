import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class FooTest {

    @Test
    public void foo() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
        mapper.setDateFormat(new SimpleDateFormat("MM-dd-yyyy HH:mm:ss"));
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        final String output = mapper.writeValueAsString(new Bar(new Date(10000000L)));
        assertThat(output, containsString("01-01-1970 03:46:40"));
    }

    private static class Bar {
        @JsonProperty("date")
        private Date date;

        public Bar() {
        }

        public Bar(Date date) {
            this.date = date;
        }
    }
}