@Entity
@Table(name = "CATEGORY_RELATIONS")
@IdClass(CategoryRelationsPrimaryKey.class)
public class CategoryRelations implements Serializable {

    @Id
    @Column(name = "CATEGORY_RELATIONS_CATEGORY_ID")
    private String categoryId;

    @Id
    @Column(name = "CATEGORY_RELATIONS_PARENT_ID")
    private String parentId;

    //...

}

public class CategoryRelationsPrimaryKey implements Serializable {
    protected String categoryId;
    protected String parentId;
    // ...
}