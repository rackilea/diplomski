@Entity
public class OrganisationNode extends EntityBase {

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name="ParentId")
    private OrganisationNode parent;

    @OneToMany
    private Set<OrganisationNode> children = new HashSet<OrganisationNode>();

}