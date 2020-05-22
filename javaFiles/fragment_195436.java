@Entity
public class Category {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private int catId;
    private String catName;

    @OneToMany(targetEntity=Expens.class, mappedBy = "category", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Expens> expenses = new ArrayList<Expens>();

    public void addToExpenses(Expense expense) {
        expenses.add(expense);
        expense.setCategory(this);
    }    

    protected List getExpenses() { // protected to prevent direct access from outside the hierarchy
        return expenses;
    }

    protected void setExpenses(List expenses) { // protected to prevent direct access
        this.expenses = expenses;
    }

    //...
}