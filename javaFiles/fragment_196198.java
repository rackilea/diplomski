import com.microsoft.azure.management.Azure;
import com.microsoft.azure.management.resources.DeploymentMode;
import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public static void DeployTest(Azure azure) {
    try(InputStream templatein = new BufferedInputStream(new FileInputStream( "D:\\iottemplate\\template.json"));
        StringWriter templateWriter = new StringWriter();
    ){
        // Read the template.json file
        IOUtils.copy(templatein, templateWriter);

        // Convert template to JSON object
        JSONObject templateNode = new JSONObject(templateWriter.toString());

        // Add default value for parameters
        JSONObject parameterValue = templateNode.optJSONObject("parameters");
        parameterValue.optJSONObject("sku_name").put("defaultValue","B1");
        parameterValue.optJSONObject("sku_units").put("defaultValue","1");
        parameterValue.optJSONObject("d2c_partitions").put("defaultValue","4");
        parameterValue.optJSONObject("location").put("defaultValue","southeastasia");
        parameterValue.optJSONObject("features").put("defaultValue","None");
        parameterValue.optJSONObject("name").put("defaultValue","jackiottest567");

        // Deploy
        azure.deployments().define("CreateIOTHub")
                .withNewResourceGroup("JackIotTest1", Region.ASIA_SOUTHEAST)
                .withTemplate(templateNode.toString())
                .withParameters("{}")
                .withMode(DeploymentMode.INCREMENTAL)
                .create();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}