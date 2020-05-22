public class Relationship {

    private final String id1;
    private final String id2;
    private final Relation relation;
    private final boolean careTaker;
    private final boolean liveTogether;

    public Relationship(JsonNode base) {
        this.id1 = base.get(0).asText();
        this.id2 = base.get(2).asText();
        this.relation = Relation.valueOf(base.get(1).asText());
        this.careTaker = base.get(3).get("careTaker").asBoolean();
        this.liveTogether = base.get(3).get("liveTogether").asBoolean();
    }

    public enum Relation {
        PARENT,
        SPOUSE;
    }

}