import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        Type testCaseListType = new TypeToken<List<TestCase>>() {}.getType();
        Type testSuiteListType = new TypeToken<List<TestSuite>>() {}.getType();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(testCaseListType, new OneOrManyJsonDeserializer<>(TestCase.class))
                .registerTypeAdapter(testSuiteListType, new OneOrManyJsonDeserializer<>(TestSuite.class))
                .setPrettyPrinting()
                .create();

        TestResponse response = gson.fromJson(new FileReader(jsonFile), TestResponse.class);
        System.out.println(response);
    }
}