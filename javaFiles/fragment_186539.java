import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class EmployeeTest {

    private static final String EXPECTED_JSON_RESULT = "{\"employee\":{\"@id\":1,\"name\":\"skanda\",\"id\":\"123\",\"employee\":[{\"@id\":2,\"id\":\"345\"}]}}";

    @Test
    public void serializationTest() throws JsonProcessingException {
        final Employee emp1 = new Employee();
        emp1.setId("123");
        emp1.setName("skanda");

        final Employee empL1 = new Employee();
        empL1.setId("345");

        final List<Employee> list = new ArrayList<>();
        list.add(empL1);

        emp1.setEmployees(list);

        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);

        Assert.assertEquals(EXPECTED_JSON_RESULT, objectMapper.writeValueAsString(emp1));
    }

}