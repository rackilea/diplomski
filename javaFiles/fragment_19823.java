import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class InningsParse {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Inning.class, new InningDeserializer());
        mapper.registerModule(module);
        try {
            Innings user = mapper.readValue(new File("a.txt"), Innings.class);
            System.out.println(ReflectionToStringBuilder.toString(user,ToStringStyle.MULTI_LINE_STYLE));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Innings {
    public List<Inning> innings;
}
class Inning{
    public int runs;
    public String team;
}
class InningDeserializer extends StdDeserializer<Inning> { 

    public InningDeserializer() { 
        this(null); 
    } 

    public InningDeserializer(Class<?> vc) { 
        super(vc); 
    }

    @Override
    public Inning deserialize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        String nodeS = node.toString();
        nodeS = nodeS.substring(nodeS.indexOf(':')+1, nodeS.toString().lastIndexOf('}'));
        System.out.println(nodeS);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(nodeS,Inning.class);
    }
}