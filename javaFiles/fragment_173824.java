import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

public class GsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        Gson gson = new GsonBuilder()
                .setFieldNamingStrategy(new FieldNamingStrategy() {
                    @Override
                    public String translateName(Field f) {
                        final String name = f.getName();
                        switch (name) {
                            case "row":
                                return "ROW_";
                            case "rowId":
                                return "ROW_ID";
                            case "violationDescription":
                                return "VIOLATIONDESC";
                            default:
                                return f.getName().toUpperCase();
                        }
                    }
                })
                .create();

        Type type = new TypeToken<List<VOMovingViolations>>() {
        }.getType();
        List<VOMovingViolations> violations = gson.fromJson(new FileReader(jsonFile), type);
        violations.forEach(System.out::println);
    }
}