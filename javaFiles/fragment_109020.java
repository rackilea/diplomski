import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.joda.time.DateTime;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.registerModule(new JodaModule());

        String json = mapper.writeValueAsString(new MyModel());
        System.out.println(json);
        MyModel model = mapper.readValue(json, MyModel.class);
        System.out.println(model);
    }
}

class MyModel {
    private DateTime now = DateTime.now();

    public DateTime getNow() {
        return now;
    }

    public void setNow(DateTime now) {
        this.now = now;
    }

    @Override
    public String toString() {
        return "MyModel{" +
                "now=" + now +
                '}';
    }
}