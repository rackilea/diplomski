import io.swagger.parser.SwaggerParser;
import io.swagger.models.Swagger;
import io.swagger.models.Operation;
import io.swagger.models.HttpMethod;
import io.swagger.models.parameters.QueryParameter;
import io.swagger.util.Yaml;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.util.Map;
...

Swagger swagger = new SwaggerParser().read("https://petstore.swagger.io/v2/swagger.json");

// Configure the "status" query parameter
QueryParameter status = new QueryParameter();
status.setName("status");
status.setType("string");
// You can also setDescription, setRequired, setExample, etc. as needed

// Get all HTTP methods for the "/pet/{petId}" path
Map<HttpMethod, Operation> operations = swagger.getPaths().get("/pet/{petId}").getOperationMap();

// Add the "status" parameter to non-GET methods only
for (Map.Entry<HttpMethod, Operation> op : operations.entrySet()){
    if (op.getKey() != HttpMethod.GET) {
        // TODO: Check if this operation already has
        // a query parameter named "status"

        op.getValue().addParameter(status);
    }
}

// Save the new file
try {
    // (Optional) Configure YAML formatter
    YAMLFactory factory = (YAMLFactory) Yaml.mapper().getFactory();
    factory.disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER)
        .enable(YAMLGenerator.Feature.MINIMIZE_QUOTES)
        .enable(YAMLGenerator.Feature.ALWAYS_QUOTE_NUMBERS_AS_STRINGS);

    String yaml = Yaml.pretty().writeValueAsString(swagger);
    FileUtils.writeStringToFile(new File("C:\\Work\\petstore-modified.yaml"), yaml);
}
catch (Exception e) {
    e.printStackTrace();
}