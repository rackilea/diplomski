import com.jayway.jsonpath.EvaluationListener;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonPathApp {
    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        List<String> paths = new ArrayList<>();
        ReadContext findPathsContext = JsonPath.parse(jsonFile).withListeners((found) -> {
            paths.add(found.path());
            return EvaluationListener.EvaluationContinuation.CONTINUE;
        });

        List<String> properties = Arrays.asList("photo", "passportPhoto");
        properties.forEach(p -> findPathsContext.read("$.." + p));

        ReadContext readContext = JsonPath.parse(jsonFile);

        for (String path : paths) {
            System.out.println("Path: " + path);
            System.out.println("Value: " + readContext.read(path));
        }
    }
}