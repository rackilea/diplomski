import java.lang.reflect.Type;
import org.junit.Test;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static org.junit.Assert.assertEquals;

public class ContainerTest {

    @Test
    public void testContainerRecord() {
        //given
        String json = "{\"id\":\"new ID\",\"content\":[{\"id\":\"50e0300a-6668-42b3-a474-81a6a08f773f\"},{\"id\":\"f0bee3f3-2c40-4b44-8608-a6fedb226b7a\"}],\"data\":\"AAAAAAAA\"}";
        //when

        Container<Record> containerRecord = Container.deserializeClass(json, ContainerRecord.class);
        //then
        assertEquals("50e0300a-6668-42b3-a474-81a6a08f773f", containerRecord.content.get(0).id);
        assertEquals("f0bee3f3-2c40-4b44-8608-a6fedb226b7a", containerRecord.content.get(1).id);
    }

    @Test
    public void testContainerRecord2() {
        //given
        String json = "{\"id\":\"new ID\",\"content\":[{\"id\":\"50e0300a-6668-42b3-a474-81a6a08f773f\"},{\"id\":\"f0bee3f3-2c40-4b44-8608-a6fedb226b7a\"}],\"data\":\"AAAAAAAA\"}";
        //when

        Container<Record> containerRecord = Container.deserialize(json, Record.class);
        //then
        assertEquals("50e0300a-6668-42b3-a474-81a6a08f773f", containerRecord.content.get(0).id);
        assertEquals("f0bee3f3-2c40-4b44-8608-a6fedb226b7a", containerRecord.content.get(1).id);
    }

    @Test
    public void testGenericWithType() {
        //given
        String json = "{\"id\":\"new ID\",\"content\":[{\"id\":\"50e0300a-6668-42b3-a474-81a6a08f773f\"},{\"id\":\"f0bee3f3-2c40-4b44-8608-a6fedb226b7a\"}],\"data\":\"AAAAAAAA\"}";
        //when
        Type type = new TypeToken<Container<Record>>() {
        }.getType();

        Container<Record> containerRecord = Container.deserializeType(json, type);
        //then
        assertEquals("50e0300a-6668-42b3-a474-81a6a08f773f", containerRecord.content.get(0).id);
        assertEquals("f0bee3f3-2c40-4b44-8608-a6fedb226b7a", containerRecord.content.get(1).id);
    }

    @Test
    public void testRecord() {
        //given
        String json = "{\"id\":\"new ID\",\"content\":[{\"id\":\"50e0300a-6668-42b3-a474-81a6a08f773f\"},{\"id\":\"f0bee3f3-2c40-4b44-8608-a6fedb226b7a\"}],\"data\":\"AAAAAAAA\"}";
        //when
        ContainerRecord containerRecord = new Gson().fromJson(json, ContainerRecord.class);
        //then
        assertEquals("50e0300a-6668-42b3-a474-81a6a08f773f", containerRecord.content.get(0).id);
        assertEquals("f0bee3f3-2c40-4b44-8608-a6fedb226b7a", containerRecord.content.get(1).id);
    }

    @Test
    public void testRecordWithType() {
        //given
        String json = "{\"id\":\"new ID\",\"content\":[{\"id\":\"50e0300a-6668-42b3-a474-81a6a08f773f\"},{\"id\":\"f0bee3f3-2c40-4b44-8608-a6fedb226b7a\"}],\"data\":\"AAAAAAAA\"}";
        //when
        Type type = new TypeToken<Container<Record>>() {
        }.getType();
        Container<Record> containerRecord = new Gson().fromJson(json, type);
        //then
        assertEquals("50e0300a-6668-42b3-a474-81a6a08f773f", containerRecord.content.get(0).id);
        assertEquals("f0bee3f3-2c40-4b44-8608-a6fedb226b7a", containerRecord.content.get(1).id);
    }

    @Test
    public void testContainerString() {
        //given
        String json = "{\"id\":\"new ID\",\"content\":[\"37c84304-ab80-4f92-8b2a-710b362ecb3f\"],\"data\":\"AAAAAAAA\"}";
        //when
        Type type = new TypeToken<Container<String>>() {
        }.getType();
        Container<String> containerRecord = new Gson().fromJson(json, type);
        //then
        assertEquals("37c84304-ab80-4f92-8b2a-710b362ecb3f", containerRecord.content.get(0));
    }


}