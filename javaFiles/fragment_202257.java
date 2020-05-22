@Entity
@Table(name = "CATEGORY_SET")
public class CategorySet {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @OneToOne
    @JoinColumn(name = "PARENT")
    private Category parent;

    @OneToOne
    @JoinColumn(name = "CHILD")
    private Category child;

    public CategorySet(Category parent, Category child) {
        this.parent = parent;
        this.child = child;
    }

    public CategorySet() {
    }
}