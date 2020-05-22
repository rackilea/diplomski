@JsonDeserialize( using = FamillyRelationshipsDeserializer.class )
public class FamillyRelationships {

    public List<Relationship> familyRelationships = new ArrayList<>();

}