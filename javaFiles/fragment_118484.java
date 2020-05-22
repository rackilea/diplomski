import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SerializeWithTypeTest {

    private JsonSerializable serializable = mock(JsonSerializable.class);

    @Test
    public void shouldCallSerializeWithType() throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper().enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        objectMapper.writeValueAsString(serializable);

        // make sure serializeWithType is called once
        verify(serializable, times(1)).serializeWithType(any(), any(), any());

    }

}