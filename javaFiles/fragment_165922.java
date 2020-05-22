@JsonDeserialize(using = BobDeserializer.class)
class Bob {

    private Integer number;

    public Bob() {
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}

@JsonDeserialize(using = AliceDeserializer.class)
public class Alice {
    private Bob bob;

    public Alice() {
    }

    public Bob getBob() {
        return bob;
    }

    public void setBob(Bob bob) {
        this.bob = bob;
    }
}

class BobDeserializer extends StdDeserializer<Bob> {

    protected BobDeserializer() {
        super(Bob.class);
    }

    public Bob deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);

        Integer number = node.get("number").asInt();

        Bob bob = new Bob();
        bob.setNumber(number);

        return bob;
    }
}

class AliceDeserializer extends StdDeserializer<Alice> {

    protected AliceDeserializer() {
        super(Alice.class);
    }

    public Alice deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);

        ObjectMapper mapper = new ObjectMapper();
        Bob bob = mapper.readValue(node.get("bob").toString(), Bob.class);

        Alice alice = new Alice();
        alice.setBob(bob);

        return alice;
    }
}