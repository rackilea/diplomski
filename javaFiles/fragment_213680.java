import static org.junit.Assert.*;
import org.junit.Test;
import com.google.gson.*;

public class JSONTest {
    @Test
    public final void testSerializeWithDTRowId() {
        Entity entity = new Entity();
        entity.creationTime = 0;
        entity.enabled = true;
        entity.id = 1;
        entity.loginDuration = 0;
        entity.online = false;
        entity.userName = "someone";

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Entity.class, new EntityJsonSerializer());
        Gson gson = builder.create();
        String json = gson.toJson(entity);
        String expectedJson = "{\"creationTime\":0,\"enabled\":true,\"id\":1,\"loginDuration\":0,\"online\":false,\"userName\":\"someone\",\"DT_RowId\":1}";
        assertEquals(expectedJson, json);
    }
}