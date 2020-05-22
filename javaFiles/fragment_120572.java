import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class EmployeeTest {

    @JsonDeserialize(using = EmployeeDeserializer.class)
    public static class Employee {

        public String name;
        public String designation;
        public String item;
        public List<Item> items;
    }

    public static class Item {

        public String name;
        public String desc;

        @Override
        public String toString() {
            return "Item{" + "name=" + name + ", desc=" + desc + '}';
        }
    }

    public static class EmployeeDeserializer extends JsonDeserializer<Employee> {

        @Override
        public Employee deserialize(JsonParser jp,
                DeserializationContext dc)
                throws IOException, JsonProcessingException {
            Employee emp = new Employee();
            JsonNode root = jp.getCodec().readTree(jp);
            emp.name = root.get("name").asText();
            emp.designation = root.get("designation").asText();
            JsonNode itemNode = root.get("item");
            if (itemNode.isArray()) {
                ArrayNode itemsNode = (ArrayNode) itemNode;
                List<Item> items = new ArrayList<>();
                for (JsonNode iNode : itemsNode) {
                    Item item = new Item();
                    item.name = iNode.get("name").asText();
                    item.desc = iNode.get("desc").asText();
                    items.add(item);
                }
                emp.items = items;
            } else if (itemNode.isObject()) {
                List<Item> items = new ArrayList<>();
                Item item = new Item();
                item.name = itemNode.get("name").asText();
                item.desc = itemNode.get("desc").asText();
                items.add(item);
                emp.items = items;
            } else {
                String item = root.get("item").asText();
                emp.item = item;
            }
            return emp;
        }
    }

    private static ObjectMapper mapper;

    @BeforeClass
    public static void setUpMapper() {
        mapper = new ObjectMapper();
        //SimpleModule module = new SimpleModule();
        //module.addDeserializer(Employee.class, new EmployeeDeserializer());
        //mapper.registerModule(module);
    }

    @Test
    public void should_deserialize_manager_list_ok() throws Exception {
        final String mgrJson
                = "{\n"
                + "  \"name\": \"Rohit\",\n"
                + "  \"designation\": \"Manager\",\n"
                + "  \"item\": [{\"name\": \"ABC\", \"desc\": \"1234\"}]\n"
                + "}";
        Employee mgr = mapper.readValue(mgrJson, Employee.class);
        assertEquals("Rohit", mgr.name);
        assertEquals("Manager", mgr.designation);
        assertNull(mgr.item);
        assertEquals(1, mgr.items.size());
        assertEquals("ABC", mgr.items.get(0).name);
        assertEquals("1234", mgr.items.get(0).desc);
    }

    @Test
    public void should_deserialize_staff_string_ok() throws Exception {

        final String staffJson
                = "{\n"
                + "  \"name\": \"Manu\",\n"
                + "  \"designation\": \"Staff\",\n"
                + "  \"item\": \"abc\"\n"
                + "}";
        Employee staff = mapper.readValue(staffJson, Employee.class);
        assertEquals("Manu", staff.name);
        assertEquals("Staff", staff.designation);
        assertEquals("abc", staff.item);
        assertNull(staff.items);
    }

    @Test
    public void should_deserialize_single_item_ok() throws Exception {
        final String mgrJson
                = "{\n"
                + "  \"name\": \"Rohit\",\n"
                + "  \"designation\": \"Manager\",\n"
                + "  \"item\": {\"name\": \"ABC\", \"desc\": \"1234\"}\n"
                + "}";
        Employee mgr = mapper.readValue(mgrJson, Employee.class);
        assertEquals("Rohit", mgr.name);
        assertEquals("Manager", mgr.designation);
        assertNull(mgr.item);
        assertEquals(1, mgr.items.size());
        assertEquals("ABC", mgr.items.get(0).name);
        assertEquals("1234", mgr.items.get(0).desc);
    }
}