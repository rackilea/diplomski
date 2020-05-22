@Entity
public class Category {
    @Id @GeneratedValue
    private Long id;

    @OneToMany(mappedBy="category")
    private Set<Expense> expenses = new HashSet<Expense>();
    ....
}