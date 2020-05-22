@Entity
@NamedEntityGraph(name = "GroupInfo.detail", attributeNodes = @NamedAttributeNode("members"))
public class GroupInfo {
    @Id UUID id;
    @ManyToMany //default fetch mode is lazy.
    List<GroupMember> members = new ArrayList<GroupMember>();
}

@Repository
public interface GroupRepository extends CrudRepository<GroupInfo, String> {

    @EntityGraph(value = "GroupInfo.detail", type = EntityGraphType.LOAD)
    GroupInfo getByGroupName(String name); //Despite of GroupInfo.members has FetchType = LAZY, it will be fetched because of using EntityGraph
}