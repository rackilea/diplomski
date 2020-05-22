@Entity
public class Expense {
    @Id @GeneratedValue
    private Long;

    @ManyToOne
    private Category category

    // getters, setters
    ...
}