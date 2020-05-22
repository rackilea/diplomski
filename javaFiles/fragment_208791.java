import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.type.MapType;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.readValue(jsonFile, TestCase.class));
    }
}

class MockResponse {
    public String parameter1;
    public String parameter2;
}

@JsonDeserialize(using = TestCaseFromExternalFileDeserializer.class)
class TestCase {

    public String responseMapFileLocation;
    public String mockResponseKey;
    public MockResponse mockResponse;
}

class TestCaseFromExternalFileDeserializer extends JsonDeserializer<TestCase> {

    private final ObjectMapper mapper;
    private final MapType mapType;

    public TestCaseFromExternalFileDeserializer() {
        mapper = new ObjectMapper();
        mapType = mapper.getTypeFactory().constructMapType(Map.class, String.class, MockResponse.class);
    }

    @Override
    public TestCase deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        TreeNode treeNode = p.readValueAsTree();

        TestCase testCase = new TestCase();
        testCase.responseMapFileLocation = ((JsonNode) treeNode.get("responseMapFileLocation")).asText();
        testCase.mockResponseKey = ((JsonNode) treeNode.get("mockResponseKey")).asText();
        parseMockResponse(testCase);

        return testCase;
    }

    private void parseMockResponse(TestCase testCase) throws IOException {
        Map<String, MockResponse> map = mapper.readValue(new File(testCase.responseMapFileLocation), mapType);

        testCase.mockResponse = map.get(testCase.mockResponseKey);
    }
}