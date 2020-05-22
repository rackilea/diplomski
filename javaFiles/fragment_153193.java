import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class EntityName {

    public static void main(String[] args) throws JsonIOException, JsonSyntaxException, FileNotFoundException {

        File f = new File("others//entity-name.json");
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(new FileReader(f));
        JsonElement element = jsonElement.getAsJsonObject().getAsJsonObject("services").get("M");
        System.out.println(element.getAsInt());
    }

}