import static org.junit.Assert.*;
import org.junit.Test;
import com.google.gson.*;

public class JSONTest {
    @Test
    public final void testSerializeWithDTRowId() {
        Entity entity = new Entity();
        entity.id = 1;
        entity.creationTime = 0;
        entity.enabled = true;
        entity.loginDuration = 0;
        entity.online = false;
        entity.userName = "someone";

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeHierarchyAdapter(PersistentObject.class, new PersistentObjectJsonSerializer());
        Gson gson = builder.create();
        String json = gson.toJson(entity);
        String expectedJson = "{\"creationTime\":0,\"enabled\":true,\"loginDuration\":0,\"online\":false,\"userName\":\"someone\",\"id\":1,\"DT_RowId\":1}";
        assertEquals(expectedJson, json);
    }
}