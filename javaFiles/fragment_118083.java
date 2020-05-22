@Entity
public class TreeNode {

    @Id
    private String name;

    @ManyToOne
    private TreeNode parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent",
        cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TreeNode> children = new ArrayList<TreeNode>( 3 );

    ...
}