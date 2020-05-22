@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class TreeNode ... {

  @OneToMany(cascade= { CascadeType.REMOVE }, mappedBy="treeNode" )
  private List<MappedRole> mappedRoles;