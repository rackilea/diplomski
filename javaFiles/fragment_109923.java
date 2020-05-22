public class Tag {

    @JsonSerialize(using = SimpleCollaborationSerializer.class)
    private Set<Collaboration> collaborations;

}