import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.internal.JsonContext;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

public class JsonPathApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        // read paths
        List<String> paths = JsonPath
                .using(Configuration.builder().options(Option.AS_PATH_LIST).build())
                .parse(jsonFile)
                .read("$.store.book[*].price", List.class);

        // compile paths
        List<JsonPath> jsonPaths = paths
                .stream()
                .map(p -> JsonPath.compile(p))
                .collect(Collectors.toList());

        // parse once for reading/updating
        JsonContext document = (JsonContext) JsonPath.parse(jsonFile);
        jsonPaths.forEach(path -> {
            BigDecimal value = document.read(path, BigDecimal.class);
            document.set(path, transform(value));
        });

        System.out.println(document.jsonString());
    }

    private static BigDecimal transform(BigDecimal value) {
        return value.setScale(0, RoundingMode.HALF_UP);
    }
}