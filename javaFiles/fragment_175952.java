import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class XmlMapperApp {

    public static void main(String[] args) throws Exception {
        File xmlFile = new File("./resource/test.xml").getAbsoluteFile();

        XmlMapper xmlMapper = new XmlMapper();

        Participants result = xmlMapper.readValue(xmlFile, Participants.class);
        System.out.println(result);
    }
}

class ParticipantsXmlAdapter extends JsonDeserializer<Participants> {

    @Override
    public Participants deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        List<Map<String, Object>> participants = readParticipantsMap(p, ctxt);

        Participants result = new Participants();
        for (Map<String, Object> participantMap : participants) {
            Object side = participantMap.get("side").toString();
            if ("AWAY".equals(side)) {
                result.setParticipantAway(convert((Map<String, Object>) participantMap.get("team")));
            } else if ("HOME".equals(side)) {
                result.setParticipantHome(convert((Map<String, Object>) participantMap.get("team")));
            }
        }

        return result;
    }

    private List<Map<String, Object>> readParticipantsMap(JsonParser p, DeserializationContext ctxt) throws IOException {
        MapType mapType = ctxt.getTypeFactory().constructMapType(Map.class, String.class, Object.class);
        JsonDeserializer<Object> mapDeserializer = ctxt.findRootValueDeserializer(mapType);
        List<Map<String, Object>> participants = new ArrayList<>();
        p.nextToken(); // skip Start of Participants object
        while (p.currentToken() == JsonToken.FIELD_NAME) {
            p.nextToken(); // skip start of Participant
            Object participant = mapDeserializer.deserialize(p, ctxt);
            participants.add((Map<String, Object>) participant);
            p.nextToken(); // skip end of Participant
        }

        return participants;
    }

    private Participant convert(Map<String, Object> map) {
        Participant participant = new Participant();
        participant.setId(Integer.parseInt(map.get("id").toString()));
        participant.setName(map.get("name").toString());

        return participant;
    }
}

@JsonDeserialize(using = ParticipantsXmlAdapter.class)
class Participants {

    private Participant participantHome;
    private Participant participantAway;

    // getters, setters, toString
}

class Participant {
    private int id;
    private String name;

    // getters, setters, toString
}